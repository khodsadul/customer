package com.tagmeds.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagmeds.customer.constants.GenericConstants;
import com.tagmeds.customer.dao.PrakrutiAnswerRepository;
import com.tagmeds.customer.dto.PrakrutiAnswerDto;
import com.tagmeds.customer.entity.PrakrutiAnswer;
import com.tagmeds.customer.exception.BaseException;
import com.tagmeds.customer.mapper.PrakrutiAnswerMapper;
import com.tagmeds.customer.service.PrakrutiAnswerService;

@Service
public class PrakrutiAnswerServiceImpl implements PrakrutiAnswerService {

	@Autowired
	private PrakrutiAnswerMapper mapper;

	@Autowired
	private PrakrutiAnswerRepository repository;

	@Override
	public PrakrutiAnswerDto addPrakrutiAnswer(PrakrutiAnswerDto requestDto) throws BaseException {
		if (requestDto != null) {
			if (requestDto.getId() != null) {
				PrakrutiAnswer prakrutiAnswer = repository.findById(requestDto.getId()).orElse(null);
				if (prakrutiAnswer != null) {
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

}
