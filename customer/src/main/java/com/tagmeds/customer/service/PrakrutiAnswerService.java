package com.tagmeds.customer.service;

import com.tagmeds.customer.dto.PrakrutiAnswerDto;
import com.tagmeds.customer.exception.BaseException;

public interface PrakrutiAnswerService {

	PrakrutiAnswerDto addPrakrutiAnswer(PrakrutiAnswerDto requestDto) throws BaseException;

}
