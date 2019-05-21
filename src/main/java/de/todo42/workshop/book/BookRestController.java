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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik
 *
 */
@RestController(value = BookRestController.REQUEST_URL)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookRestController {

	public static final String REQUEST_URL = "/book";
	
	@NonNull
	private BookService bookService;
	
	
	@GetMapping
	public Book getSingleBook() {
		return bookService.loadSingleBook();
	}
}
