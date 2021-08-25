package com.tagmeds.customer.dto;

import java.util.Set;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrakrutiQuestionCategoryDto extends BaseDto {

	private Integer id;

	@Size(max = 255)
	private String name;

	Set<PrakrutiOptionDto> prakrutiOptions;

}
