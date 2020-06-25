package com.management.orderitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.management.orderitem.entity.OrderItems;
import com.management.orderitem.service.OrderItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@HystrixCommand(fallbackMethod = "getOrderItemDetailsFallback", groupKey = "getOrderItemDetails", commandKey = "getOrderItemDetails")
	@GetMapping(value = "/getOrdersItemDetails", produces = "application/json")
	public OrderItems getOrderItemDetails(@RequestParam("productId") Integer productId) {
		return orderItemService.getOrderItemDetails(productId);
	}

	public OrderItems getOrderItemDetailsFallback(Integer orderId) {
		return null;
	}

	@HystrixCommand(fallbackMethod = "createOrdersItemsFallback", groupKey = "createOrderItems", commandKey = "createOrderItems")
	@PutMapping(value = "/createOrderItem")
	public ResponseEntity<String> createOrderItems(@RequestBody OrderItems orderItem) {
		return orderItemService.createOrderItems(orderItem);
	}

	public ResponseEntity<String> createOrdersItemsFallback(OrderItems orderItem) {
		return ResponseEntity.ok(HttpStatus.NO_CONTENT.toString());
	}
	
	

}
