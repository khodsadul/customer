package com.tagmeds.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/*
 * @author AKSHAYM
 */

public class DuplicateKeyException extends Exception {

	private static final long serialVersionUID = -1635148452692559021L;
	public static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
	public static final String DEFAULT_MESSAGE = "Duplicate key is entered!";

	private final HttpStatus httpStatus;
	private final String message;

	public DuplicateKeyException(HttpStatus httpStatus, String message) {
		this(httpStatus, DEFAULT_HTTP_STATUS, message, DEFAULT_MESSAGE);
	}

	@SuppressWarnings("deprecation")
	public DuplicateKeyException(HttpStatus httpStatus, HttpStatus defaultStatus, String message,
			String defaultMessage) {
		super();
		this.httpStatus = null == httpStatus ? defaultStatus : httpStatus;
		this.message = StringUtils.isEmpty(message) ? defaultMessage : message;
	}

	public DuplicateKeyException(String message) {
		this(DEFAULT_HTTP_STATUS, message);
	}

	public DuplicateKeyException() {
		this(DEFAULT_HTTP_STATUS, DEFAULT_MESSAGE);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
