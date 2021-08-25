package com.tagmeds.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prakruti_answer")
public class PrakrutiAnswer extends BaseEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "prakruti_category_id")
	private Integer prakrutiCategoryId;

	@Size(max = 255)
	@Column(name = "value_sequence")
	private Integer valueSequence;

}
