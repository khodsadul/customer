package com.tagmeds.customer.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tagmeds.customer.entity.id.PrakrutiOptionId;

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
@Table(name = "prakruti_option")
public class PrakrutiOption extends BaseEntity {

	@EmbeddedId
	private PrakrutiOptionId id;

	@Column(name = "value")
	private String value;

}
