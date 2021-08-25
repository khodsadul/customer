package com.tagmeds.customer.dto;

import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PrakrutiOptionDto extends BaseDto {

	private Integer prakrutiCategoryId;

	@Size(max = 255)
	private Integer sequence;

	private String value;

}
