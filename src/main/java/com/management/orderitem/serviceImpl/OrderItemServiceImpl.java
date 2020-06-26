package com.management.orderitem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	//get item details based on order and product code
	@Override
	public ResponseEntity<OrderItems> getOrderItemDetails(Integer orderId, String productCode) {
		Optional<List<OrderItems>> orderItems = orderItemRepository.getItemDetails(orderId);
		if (orderItems.isPresent())
			return ResponseEntity.ok(orderItems.get().stream()
					.filter(item -> item.getProductCode().equalsIgnoreCase(productCode)).findAny().get());
		else
			return ResponseEntity.ok(new OrderItems());
	}

	//create order items
	@Override
	public ResponseEntity<String> createOrderItems(OrderItems orderItem) {
		try {
			orderItemRepository.save(orderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("successfully saved item");
	}

	//get all items related to order id
	@Override
	public ResponseEntity<List<OrderItems>> getOrderItemDetails(Integer orderId) {
		Optional<List<OrderItems>> orderItems = orderItemRepository.getItemDetails(orderId);
		if (orderItems.isPresent())
			return ResponseEntity.ok(orderItems.get());
		else
			return ResponseEntity.ok(new ArrayList<OrderItems>());
	}

}
