package com.tagmeds.customer.service;

import com.tagmeds.customer.dto.PrakrutiQuestionCategoryDto;
import com.tagmeds.customer.dto.request.PageableRequest;
import com.tagmeds.customer.dto.response.PageableResponse;
import com.tagmeds.customer.exception.BaseException;

public interface PrakrutiQuestionCategoryService {

	PrakrutiQuestionCategoryDto addPrakrutiQuestionCategory(PrakrutiQuestionCategoryDto requestDto)
			throws BaseException;

	PageableResponse<PrakrutiQuestionCategoryDto> getPrakrutiQuestionCategory(PageableRequest request);

}
