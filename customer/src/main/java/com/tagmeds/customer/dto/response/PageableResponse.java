package com.tagmeds.customer.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableResponse<T> {

	private int totalPages;
	private int currentPage;
	private long totalRecord;
	private List<T> data;

}
