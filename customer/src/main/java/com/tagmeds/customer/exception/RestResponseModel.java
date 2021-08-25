package com.tagmeds.customer.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseModel<T> {

    private Boolean success;
    private T data;
    private String message;
    private ErrorResponseModel error;


    public RestResponseModel(Boolean success, ErrorResponseModel error) {
        super();
        this.success = success;
        this.error = error;
    }
}
