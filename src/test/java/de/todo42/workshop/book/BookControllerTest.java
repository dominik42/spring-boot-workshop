package de.todo42.workshop.book;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.todo42.workshop.ValueStore;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;
    
    // object under test
    private BookRestController controller;
    
    @Before
    public void setup() {
        controller = new BookRestController(bookService); // constructor injection
        when(bookService.loadSingleBook(anyString())).thenReturn(ValueStore.book());
    }
    
    
    @Test
    public void testSingleBook() throws Exception {
        Book book = controller.getSingleBook("978-3864905254");
        assertThat(book.getTitle(), is("Spring Boot 2"));
    }
    
    
}
