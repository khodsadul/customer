package com.tagmeds.customer.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.tagmeds.customer.constants.GenericConstants;
import com.tagmeds.customer.dto.request.PageableRequest;

@Component
public class CustomerUtilsService {

	@Value("${default.page.size}")
	private int pageSize;

	public PageRequest preparePageableRequest(PageableRequest request) {
		int page;
		pageSize = 0 == request.getSize() ? pageSize : request.getSize();
		page = 0 == request.getPage() ? 0 : request.getPage();
		Sort sort = null == request.getSortby() ? Sort.by(defaultPageableSortBy())
				: Sort.by(preparePageableOrders(request.getSortby()));
		return PageRequest.of(page, pageSize, sort);
	}

	private List<Order> preparePageableOrders(String sortby) {
		List<Sort.Order> orders = new ArrayList<>();
		String[] sortList = sortby.split(",");
		for (String sort : sortList) {
			String compositeName = sort.split(":")[1];
			orders.add(new Order(GenericConstants.DIRECTION_ASC.equalsIgnoreCase(sort.split(":")[0]) ? Direction.ASC
					: Direction.DESC, compositeName));
		}
		return orders;
	}

	private List<Order> defaultPageableSortBy() {
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, GenericConstants.EntityConstants.MODIFIED_DTTM));
		orders.add(new Order(Direction.DESC, GenericConstants.EntityConstants.VERSION));
		return orders;
	}
}
