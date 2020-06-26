package com.management.orderitem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.management.orderitem.entity.OrderItems;

public interface OrderItemService {

	ResponseEntity<OrderItems> getOrderItemDetails(Integer orderId,String productCode);

	ResponseEntity<String> createOrderItems(OrderItems orderItem);

	ResponseEntity<List<OrderItems>> getOrderItemDetails(Integer orderId);


}
