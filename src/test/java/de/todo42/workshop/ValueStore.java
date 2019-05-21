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

import de.todo42.workshop.book.Book;

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
}
