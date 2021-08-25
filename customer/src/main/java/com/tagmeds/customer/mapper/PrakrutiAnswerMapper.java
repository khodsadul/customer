package com.tagmeds.customer.mapper;

import org.mapstruct.Mapper;

import com.tagmeds.customer.dto.PrakrutiAnswerDto;
import com.tagmeds.customer.entity.PrakrutiAnswer;

@Mapper(componentModel = "spring")
public interface PrakrutiAnswerMapper extends GenericMapper<PrakrutiAnswer, PrakrutiAnswerDto> {

}
