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

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//@NonNull
    private BookValidator bookValidator = new BookValidator();
    
    
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.addValidators(bookValidator);
	}
	
	@GetMapping
	public Collection<Book> getAllBooks() {
		return bookService.loadAllBooks();
	}

	@GetMapping(path = REQUEST_URL + "/{isbn}")
	public Book getSingleBook(@PathVariable(name = "isbn", required = true) String isbn) {
		return bookService.loadSingleBook(isbn);
	}

	@GetMapping(path = REQUEST_URL, params = "isbn")
	public Book getSingleBook2(@RequestParam(name = "isbn", required = true) String isbn) {
		return bookService.loadSingleBook(isbn);
	}
	
	// curl --header "Content-Type: application/json" -X POST --data '{"title":"title","author":"author","isbn":"NmAk6uVlEzLuTi"}'  http://localhost:8088/book
	@PostMapping
	public Book createBook(@Valid @RequestBody(required = true) Book book,
	        BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        throw new RuntimeException(bindingResult.toString());
	    }
	    return bookService.save(book);
	}
	
	
}
