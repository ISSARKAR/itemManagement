package com.management.orderitem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.orderitem.entity.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>{

	@Query(nativeQuery = true,value = "select * from order_items where order_id=:")
	Optional<List<OrderItems>> getItemDetails(Integer orderId);

}
