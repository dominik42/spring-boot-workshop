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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dominik
 *
 */
@Data
@Builder
@NoArgsConstructor // needed by jackson
@AllArgsConstructor // needed by @Builder if @NoArgsConstructor given
public class Book {

	private String title;
	private String author;
	private String isbn;
	
	@JsonBackReference
	private Publisher publisher;
}
