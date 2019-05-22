package de.todo42.workshop.book;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookIntegrationTest {

    @Autowired
    private BookRestController restController;
    
    
    @Test
    public void testSingleBook() throws Exception {
        Book book = restController.getSingleBook("978-3864905254");
        assertThat(book.getTitle(), is("Spring Boot 2"));
    }
    
    
}
