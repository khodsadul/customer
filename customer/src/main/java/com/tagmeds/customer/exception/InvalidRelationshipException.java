package com.tagmeds.customer.exception;

import org.springframework.http.HttpStatus;

public class InvalidRelationshipException extends BaseException {

	private static final long serialVersionUID = 8368549761637725897L;
	public static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
	public static final String DEFAULT_MESSAGE = "Relationship with itself is not allowed. ";

	public InvalidRelationshipException() {
		this(DEFAULT_HTTP_STATUS, DEFAULT_MESSAGE);
	}

	public InvalidRelationshipException(HttpStatus httpStatus, String message) {
		super(httpStatus, DEFAULT_HTTP_STATUS, message, DEFAULT_MESSAGE);
	}

	public InvalidRelationshipException(String message) {
		this(DEFAULT_HTTP_STATUS, message);
	}

}
