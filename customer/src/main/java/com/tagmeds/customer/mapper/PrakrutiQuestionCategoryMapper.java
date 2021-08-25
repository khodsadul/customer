package com.tagmeds.customer.mapper;

import org.mapstruct.Mapper;

import com.tagmeds.customer.dto.PrakrutiQuestionCategoryDto;
import com.tagmeds.customer.entity.PrakrutiQuestionCategory;

@Mapper(componentModel = "spring", uses = PrakrutiOptionMapper.class)
public interface PrakrutiQuestionCategoryMapper
		extends GenericMapper<PrakrutiQuestionCategory, PrakrutiQuestionCategoryDto> {

}
