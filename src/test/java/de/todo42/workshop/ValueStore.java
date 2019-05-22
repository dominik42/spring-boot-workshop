/*
 * Copyright (c) 2019 todo42 Software GmbH
 *                    Blomberger Str. 6
 *                    04758 Oschatz
 *
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of todo42 Software GmbH ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license
 * agreement you entered into with todo42 Software GmbH.
 *
 */

package de.todo42.workshop;

import org.apache.commons.lang3.RandomStringUtils;

import de.todo42.workshop.book.Book;
import de.todo42.workshop.book.Publisher;

/**
 * @author Dominik
 *
 */
public class ValueStore {

	public static Book book() {
		Book book = Book.builder()
				.author("Michael Simons")
				.title("Spring Boot 2")
				.isbn("978-3-86490-525-4")
				.build();
		return book;
	}

	public static Book randomBook() {
	    Book book = Book.builder()
	            .author(RandomStringUtils.randomAscii(10))
	            .title(RandomStringUtils.randomAscii(20))
	            .isbn(RandomStringUtils.randomAlphanumeric(14))
	            .build();
	    return book;
	}
	
	public static Publisher publisher() {
	    Publisher publisher = new Publisher();
	    publisher.setName("The Publisher");
	    publisher.addBook(randomBook());
	    publisher.addBook(randomBook());
	    return publisher;
	}
}
