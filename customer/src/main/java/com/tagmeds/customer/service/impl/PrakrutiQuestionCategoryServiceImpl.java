package com.tagmeds.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tagmeds.customer.constants.GenericConstants;
import com.tagmeds.customer.dao.PrakrutiQuestionCategoryRepository;
import com.tagmeds.customer.dto.PrakrutiQuestionCategoryDto;
import com.tagmeds.customer.dto.request.PageableRequest;
import com.tagmeds.customer.dto.response.PageableResponse;
import com.tagmeds.customer.entity.PrakrutiQuestionCategory;
import com.tagmeds.customer.exception.BaseException;
import com.tagmeds.customer.mapper.PrakrutiQuestionCategoryMapper;
import com.tagmeds.customer.service.PrakrutiQuestionCategoryService;
import com.tagmeds.customer.util.CustomerUtilsService;

@Service
public class PrakrutiQuestionCategoryServiceImpl implements PrakrutiQuestionCategoryService {

	@Autowired
	PrakrutiQuestionCategoryMapper mapper;

	@Autowired
	CustomerUtilsService util;

	@Autowired
	PrakrutiQuestionCategoryRepository repository;

	@Override
	public PrakrutiQuestionCategoryDto addPrakrutiQuestionCategory(PrakrutiQuestionCategoryDto requestDto)
			throws BaseException {
		if (requestDto != null) {
			if (requestDto.getId() != null) {
				PrakrutiQuestionCategory questionCategory = repository.findById(requestDto.getId()).orElse(null);
				if (questionCategory != null) {
					throw new BaseException(GenericConstants.MessageConstants.RECORD_ALREADY_EXISTS);
				} else {
					return mapper.entityToDto(repository.save(mapper.dtoToEntity(requestDto)));
				}
			}
		} else {
			throw new BaseException(GenericConstants.MessageConstants.INVALID_REQUEST);
		}
		return requestDto;
	}

	@Override
	public PageableResponse<PrakrutiQuestionCategoryDto> getPrakrutiQuestionCategory(PageableRequest request) {
		PageRequest defaultPage = util.preparePageableRequest(request);
		return buildPageableResponse(repository.findAll(defaultPage));
	}

	private PageableResponse<PrakrutiQuestionCategoryDto> buildPageableResponse(Page<PrakrutiQuestionCategory> page) {
		PageableResponse<PrakrutiQuestionCategoryDto> response = new PageableResponse<>();
		response.setCurrentPage(page.getNumber());
		response.setTotalRecord(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		response.setData(mapper.entityCollectionToDtoList(page.getContent()));
		return response;
	}

}
