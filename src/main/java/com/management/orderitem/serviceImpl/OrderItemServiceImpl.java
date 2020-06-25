package com.management.orderitem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.orderitem.entity.OrderItems;
import com.management.orderitem.repository.OrderItemRepository;
import com.management.orderitem.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public OrderItems getOrderItemDetails(Integer productId) {
		OrderItems orderItem = null;
		try {
			orderItem = orderItemRepository.getOne(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public ResponseEntity<String> createOrderItems(OrderItems orderItem) {
		try {
			orderItemRepository.save(orderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("successfully saved item");
	}

}
