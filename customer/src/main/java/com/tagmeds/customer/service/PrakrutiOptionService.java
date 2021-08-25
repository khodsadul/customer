package com.tagmeds.customer.service;

import com.tagmeds.customer.dto.PrakrutiOptionDto;
import com.tagmeds.customer.exception.BaseException;

public interface PrakrutiOptionService {

	PrakrutiOptionDto addPrakrutiOption(PrakrutiOptionDto requestDto) throws BaseException;

}
