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

package de.todo42.workshop.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dominik
 *
 */
@RestController(value = BookRestController.REQUEST_URL)
public class BookRestController {

	public static final String REQUEST_URL = "/book";
	
	@GetMapping
	public Book getSingleBook() {
		Book book = Book.builder()
				.author("Michael Simons")
				.title("Spring Boot 2")
				.isbn("978-3-86490-525-4")
				.build();
		return book;
	}
}
