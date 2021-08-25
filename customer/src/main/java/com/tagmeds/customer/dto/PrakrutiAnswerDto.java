package com.tagmeds.customer.dto;

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
public class PrakrutiAnswerDto extends BaseDto {

	private Integer id;

	private Integer prakrutiCategoryId;

	@Size(max = 255)
	private Integer valueSequence;

}
