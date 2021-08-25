package com.tagmeds.customer.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.tagmeds.customer.dto.PrakrutiOptionDto;
import com.tagmeds.customer.entity.PrakrutiOption;

@Mapper(componentModel = "spring")
public interface PrakrutiOptionMapper {

	@Mapping(target = "id.prakrutiQuestionCategoryId.id", source = "prakrutiCategoryId")
	@Mapping(target = "id.sequence", source = "sequence")
	public PrakrutiOption prakrutiOptionDtoToPrakrutiOption(PrakrutiOptionDto dto);

	@Mappings({ @Mapping(target = "prakrutiCategoryId", source = "id.prakrutiQuestionCategoryId.id"),
			@Mapping(target = "sequence", source = "id.sequence") })
	public PrakrutiOptionDto prakrutiOptionToPrakrutiOptionDto(PrakrutiOption entity);

	@InheritConfiguration(name = "prakrutiOptionDtoToPrakrutiOption")
	public List<PrakrutiOption> prakrutiOptionDtoListToPrakrutiOptionList(List<PrakrutiOptionDto> dtos);

	public List<PrakrutiOptionDto> prakrutiOptionListToPrakrutiOptionDtoList(List<PrakrutiOption> entities);

	@InheritConfiguration(name = "prakrutiOptionToPrakrutiOptionDto")
	public Collection<PrakrutiOptionDto> prakrutiOptionCollectionToPrakrutiOptionDtoCollection(
			Collection<PrakrutiOption> entities);

	public List<PrakrutiOptionDto> prakrutiOptionCollectionToPrakrutiOptionDtoList(Collection<PrakrutiOption> entities);

	@Mappings({ @Mapping(target = "id.prakrutiQuestionCategoryId.id", source = "prakrutiCategoryId"),
			@Mapping(target = "id.sequence", source = "sequence") })
	PrakrutiOption updateDtoToEntity(PrakrutiOptionDto dto, @MappingTarget PrakrutiOption entity);

}
