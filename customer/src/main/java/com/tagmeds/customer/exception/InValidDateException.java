package com.tagmeds.customer.exception;

import org.springframework.http.HttpStatus;

public class InValidDateException extends BaseException {

	private static final long serialVersionUID = 100685049533765547L;
	public static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
	public static final String DEFAULT_MESSAGE = "End date can not be before Start date.";

	public InValidDateException() {
		this(DEFAULT_HTTP_STATUS, DEFAULT_MESSAGE);
	}

	public InValidDateException(HttpStatus httpStatus, String message) {
		super(httpStatus, DEFAULT_HTTP_STATUS, message, DEFAULT_MESSAGE);
	}

	public InValidDateException(String message) {
		this(DEFAULT_HTTP_STATUS, message);
	}

}
