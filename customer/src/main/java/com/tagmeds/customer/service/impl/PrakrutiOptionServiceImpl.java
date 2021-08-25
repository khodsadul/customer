package com.tagmeds.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagmeds.customer.constants.GenericConstants;
import com.tagmeds.customer.dao.PrakrutiOptionRepository;
import com.tagmeds.customer.dto.PrakrutiOptionDto;
import com.tagmeds.customer.entity.PrakrutiOption;
import com.tagmeds.customer.exception.BaseException;
import com.tagmeds.customer.mapper.PrakrutiOptionMapper;
import com.tagmeds.customer.service.PrakrutiOptionService;

@Service
public class PrakrutiOptionServiceImpl implements PrakrutiOptionService {

	@Autowired
	private PrakrutiOptionMapper mapper;

	@Autowired
	private PrakrutiOptionRepository repository;

	@Override
	public PrakrutiOptionDto addPrakrutiOption(PrakrutiOptionDto requestDto) throws BaseException {
		if (requestDto != null) {
			PrakrutiOption prakrutiOption = mapper.prakrutiOptionDtoToPrakrutiOption(requestDto);
			if (prakrutiOption != null && prakrutiOption.getId() != null) {
				PrakrutiOption existingPrakrutiOption = repository.findById(prakrutiOption.getId()).orElse(null);
				if (existingPrakrutiOption != null) {
					throw new BaseException(GenericConstants.MessageConstants.RECORD_ALREADY_EXISTS);
				} else {
					return mapper.prakrutiOptionToPrakrutiOptionDto(repository.save(prakrutiOption));
				}
			}
		} else {
			throw new BaseException(GenericConstants.MessageConstants.INVALID_REQUEST);
		}
		return requestDto;
	}

}
