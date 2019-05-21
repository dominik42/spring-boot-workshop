package de.todo42.workshop.book;

import org.springframework.stereotype.Service;

/**
 * @author Dominik
 *
 */
@Service
public class BookService {

	public Book loadSingleBook() {
		Book book = Book.builder()
				.author("Michael Simons")
				.title("Spring Boot 2")
				.isbn("978-3-86490-525-4")
				.build();
		return book;
	}
	
}
