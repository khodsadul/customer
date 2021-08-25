package com.tagmeds.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tagmeds.customer.entity.PrakrutiOption;
import com.tagmeds.customer.entity.id.PrakrutiOptionId;

public interface PrakrutiOptionRepository extends JpaRepository<PrakrutiOption, PrakrutiOptionId> {

}
