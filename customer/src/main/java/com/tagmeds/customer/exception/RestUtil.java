package com.tagmeds.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestUtil {
	private RestUtil() {
	}

	public static <T> ResponseEntity<RestResponseModel<T>> errorResponse(ErrorResponseModel errorResponse,
			HttpStatus statusCode) {
		return new ResponseEntity<>(new RestResponseModel<>(Boolean.FALSE, errorResponse), statusCode);
	}

}
