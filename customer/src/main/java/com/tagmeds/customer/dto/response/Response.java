package com.tagmeds.customer.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

	private boolean success;
	private Object data;
	private String message;
	
	public Response(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}
	
	public Response(boolean success, Object data, String message) {
		this.success = success;
		this.data = data;
		this.message = message;
	}
	
}
