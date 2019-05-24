package de.todo42.workshop.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.todo42.workshop.ValueStore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMockMvcTest {

    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    private ObjectMapper mapper; 
        
    
    @Before
    public void setup() {
        
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .alwaysDo(print())
                .build();
    }
    
    @Test
    public void testSingleBook() throws Exception {
        ResultActions result = mockMvc.perform(get("/book/978-3864905254")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Spring Boot 2"));
        
    }

    @Test
    public void testBookList() throws Exception {
        ResultActions result = mockMvc.perform(get("/book")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        
    }
    
    @Test
    public void testBooks() throws Exception {
        ResultActions result = mockMvc.perform(get("/book/978-3864905254")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
        
        String json = result.andReturn().getResponse().getContentAsString();
        
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(json, Book.class);
        assertNotNull(book);
        assertEquals("Spring Boot 2", book.getTitle());
        
    }
    
    @Test
    public void testValidateBook() throws Exception {
        Book book = ValueStore.book();
        book.setIsbn("123");
            
        ResultActions result = mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(book)))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
        
    }

    
    
}
