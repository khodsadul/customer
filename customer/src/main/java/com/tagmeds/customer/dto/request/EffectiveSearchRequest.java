/***********************************************************************
 * Copyright (c) 2020 RIA Advisory LLC.
 * All rights reserved.
 *
 * @author: Sadul Khod
 *
 * Change History:
 * Date Changed              Author                 Description
 * 24-Jun-2021               Sadul Khod             Initial
 *
 ***********************************************************************/
package com.tagmeds.customer.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class EffectiveSearchRequest extends SearchRequest {

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime effectiveDate;

}
