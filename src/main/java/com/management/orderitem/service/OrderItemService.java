package com.management.orderitem.service;

import org.springframework.http.ResponseEntity;

import com.management.orderitem.entity.OrderItems;

public interface OrderItemService {

	OrderItems getOrderItemDetails(Integer productId);

	ResponseEntity<String> createOrderItems(OrderItems orderItem);


}
