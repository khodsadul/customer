package com.tagmeds.customer.exception;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tagmeds.customer.controller.PrakrutiController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(assignableTypes = { PrakrutiController.class })
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<RestResponseModel<Object>> handleUnknownException(Exception ex, WebRequest request) {
		log.error("Unknown Exception occurred. Root cause is {}", ex.getMessage());
		ex.printStackTrace();
		ErrorResponseModel errorResponse = getErrorResponse(ex);
		// We return the default error message and just log the original exception
		// message.
		errorResponse.setMessage(BaseException.DEFAULT_MESSAGE);
		return RestUtil.errorResponse(errorResponse, BaseException.DEFAULT_HTTP_STATUS);
	}

	@ExceptionHandler(value = { BaseException.class })
	protected ResponseEntity<RestResponseModel<Object>> handleBaseException(BaseException ex, WebRequest request) {
		log.error("Exception occurred. Root cause is {}", ex.getMessage());
		ex.printStackTrace();
		ErrorResponseModel errorResponse = getErrorResponse(ex);
		return RestUtil.errorResponse(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(value = { PersistenceException.class })
	protected ResponseEntity<RestResponseModel<Object>> handleEntityException(PersistenceException ex,
			WebRequest request) {
		log.error("Exception occurred. Root cause is {}", ex.getMessage());
		ErrorResponseModel errorResponse = getErrorResponse(ex);
		return RestUtil.errorResponse(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errors = convertConstraintViolation(ex);
		ErrorResponseModel errorResponse = new ErrorResponseModel(null, errors);
		return new ResponseEntity<>(new RestResponseModel<>(Boolean.FALSE, errorResponse), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponseModel errorResponse = new ErrorResponseModel(null, ex.getMessage());
		return new ResponseEntity<>(new RestResponseModel<>(Boolean.FALSE, errorResponse), HttpStatus.BAD_REQUEST);
	}

	private ErrorResponseModel getErrorResponse(Exception ex) {
		return new ErrorResponseModel(null, ex.getMessage());
	}

	private String convertConstraintViolation(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> errorMessages = new ArrayList<>();
		for (FieldError c : fieldErrors) {
			errorMessages.add(c.getField() + '-' + c.getDefaultMessage());
		}
		return errorMessages.toString();
	}

	// Handles duplicate key error
	@ExceptionHandler(value = { DuplicateKeyException.class })
	protected ResponseEntity<RestResponseModel<Object>> handleDuplicateKeyException(DuplicateKeyException ex,
			WebRequest request) {
		log.error("Exception occurred. Root cause is {}", ex.getMessage());
		ErrorResponseModel errorResponse = getErrorResponse(ex);
		return RestUtil.errorResponse(errorResponse, ex.getHttpStatus());
	}
}
