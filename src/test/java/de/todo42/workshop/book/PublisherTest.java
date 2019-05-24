package de.todo42.workshop.book;

import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.todo42.workshop.ValueStore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherTest {

    @Autowired
    private ObjectMapper mapper;
    
    @TestConfiguration
    static class Config {
        @Bean
        public ObjectMapper mapper() {
            return new ObjectMapper();
        }
    }
    
    @Test
    public void testJson() throws Exception {
        Publisher publisher = ValueStore.publisher();
        String json = mapper.writeValueAsString(publisher);
        System.out.println(json);
        System.out.println(URLEncoder.encode("Content-Type: application/json"));
    }
    
    
    
}
