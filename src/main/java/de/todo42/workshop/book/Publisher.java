package de.todo42.workshop.book;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    private String name;
    
    @JsonManagedReference
    private List<Book> books;
    
    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<Book>();
        }
        book.setPublisher(this);
        books.add(book);
        
    }
    
}
