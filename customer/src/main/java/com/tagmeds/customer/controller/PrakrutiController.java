package com.tagmeds.customer.controller;

import static com.tagmeds.customer.constants.GenericConstants.API_END_POINT_CONSTANTS.ALL;
import static com.tagmeds.customer.constants.GenericConstants.API_END_POINT_CONSTANTS.PRAKRUTI;
import static com.tagmeds.customer.constants.GenericConstants.API_END_POINT_CONSTANTS.PRAKRUTI_ANSWER;
import static com.tagmeds.customer.constants.GenericConstants.API_END_POINT_CONSTANTS.PRAKRUTI_OPTION;
import static com.tagmeds.customer.constants.GenericConstants.API_END_POINT_CONSTANTS.QUESTION_CATEGORY;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tagmeds.customer.constants.GenericConstants;
import com.tagmeds.customer.constants.GenericConstants.MessageConstants;
import com.tagmeds.customer.dto.PrakrutiAnswerDto;
import com.tagmeds.customer.dto.PrakrutiOptionDto;
import com.tagmeds.customer.dto.PrakrutiQuestionCategoryDto;
import com.tagmeds.customer.dto.request.PageableRequest;
import com.tagmeds.customer.dto.response.PageableResponse;
import com.tagmeds.customer.dto.response.Response;
import com.tagmeds.customer.exception.BaseException;
import com.tagmeds.customer.service.PrakrutiAnswerService;
import com.tagmeds.customer.service.PrakrutiOptionService;
import com.tagmeds.customer.service.PrakrutiQuestionCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = PRAKRUTI)
public class PrakrutiController {

	@Autowired
	private PrakrutiOptionService prakrutiOptionService;

	@Autowired
	private PrakrutiAnswerService prakrutiAnswerService;

	@Autowired
	private PrakrutiQuestionCategoryService prakrutiQsnCategoryService;

	@PostMapping(QUESTION_CATEGORY)
	Response addPrakrutiQuestionCategory(@Valid @RequestBody PrakrutiQuestionCategoryDto requestDto)
			throws BaseException {
		log.debug("PrakrutiController|addPrakrutiQuestionCategory|Enter request = {}", requestDto.toString());
		PrakrutiQuestionCategoryDto response = prakrutiQsnCategoryService.addPrakrutiQuestionCategory(requestDto);
		log.debug("PrakrutiController|addPrakrutiQuestionCategory|Exit response = {}", response.toString());
		return new Response(true, response, GenericConstants.MessageConstants.RECORD_RETRIEVED_SUCCESSFULLY);

	}

	@PostMapping(PRAKRUTI_OPTION)
	Response addPrakrutiOption(@Valid @RequestBody PrakrutiOptionDto requestDto) throws BaseException {
		log.debug("PrakrutiController|addPrakrutiOption|Enter request = {}", requestDto.toString());
		PrakrutiOptionDto response = prakrutiOptionService.addPrakrutiOption(requestDto);
		log.debug("PrakrutiController|addPrakrutiOption|Exit response = {}", response.toString());
		return new Response(true, response, GenericConstants.MessageConstants.RECORD_RETRIEVED_SUCCESSFULLY);

	}

	@PostMapping(PRAKRUTI_ANSWER)
	Response addPrakrutiAnswer(@Valid @RequestBody PrakrutiAnswerDto requestDto) throws BaseException {
		log.debug("PrakrutiController|addPrakrutiAnswer|Enter request = {}", requestDto.toString());
		PrakrutiAnswerDto response = prakrutiAnswerService.addPrakrutiAnswer(requestDto);
		log.debug("PrakrutiController|addPrakrutiAnswer|Exit response = {}", response.toString());
		return new Response(true, response, GenericConstants.MessageConstants.RECORD_RETRIEVED_SUCCESSFULLY);

	}

	@GetMapping(QUESTION_CATEGORY + "/" + ALL)
	public Response getPrakrutiQuestionCategory(PageableRequest request) throws JsonProcessingException, BaseException {
		log.debug("PrakrutiController|getPrakrutiQuestionCategory|Enter request = {}", request.toString());
		PageableResponse<PrakrutiQuestionCategoryDto> prakrutiQsnCategoryDtos = prakrutiQsnCategoryService
				.getPrakrutiQuestionCategory(request);
		log.debug("PrakrutiController|getPrakrutiQuestionCategory|Exit response = {}",
				prakrutiQsnCategoryDtos.toString());
		return new Response(true, prakrutiQsnCategoryDtos, MessageConstants.RECORD_RETRIEVED_SUCCESSFULLY);
	}

}
