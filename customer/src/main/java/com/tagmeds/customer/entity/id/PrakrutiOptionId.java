package com.tagmeds.customer.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.tagmeds.customer.entity.PrakrutiQuestionCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PrakrutiOptionId implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "prakruti_category_id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private PrakrutiQuestionCategory prakrutiQuestionCategoryId;

	@Size(max = 255)
	@Column(name = "sequence")
	private Integer sequence;

}
