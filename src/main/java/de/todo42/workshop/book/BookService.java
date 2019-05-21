package de.todo42.workshop.book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author Dominik
 *
 */
@Service
public class BookService {

	private Map<String, Book> bookMap;
	
	@SuppressWarnings("serial")
	public BookService() {

		Book book1 = Book.builder()
				.author("Michael Simons")
				.title("Spring Boot 2")
				.isbn("978-3864905254")
				.build();
		Book book2 = Book.builder()
				.author("Robert C. Martin")
				.title("Clean Code")
				.isbn("978-0132350884")
				.build();
		Book book3 = Book.builder()
				.author("E. Gamma, R. Helm, R. Johnson, J. Vlissides")
				.title("Design Patterns. Elements of Reusable Object-Oriented Software.")
				.isbn("978-3-86490-525-4")
				.build();
		
		bookMap = new HashMap<String, Book>() {{
			put(book1.getIsbn(), book1);
			put(book2.getIsbn(), book2);
			put(book3.getIsbn(), book3);
		}};
		
	}
	
	public Collection<Book> loadAllBooks() {
		return bookMap.values();
	}

	public Book loadSingleBook(String isbn) {
		return bookMap.get(isbn);
	}

	
}
