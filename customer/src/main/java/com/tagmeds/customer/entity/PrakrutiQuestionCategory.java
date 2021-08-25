package com.tagmeds.customer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prakruti_question_category")
public class PrakrutiQuestionCategory extends BaseEntity {

	@Id
	@Column(name = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Integer id;

	@Size(max = 255)
	@Column(name = "name")
	private String name;

	@Builder.Default
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id.prakrutiQuestionCategoryId", orphanRemoval = true)
	Set<PrakrutiOption> prakrutiOptions = new HashSet<>();

}
