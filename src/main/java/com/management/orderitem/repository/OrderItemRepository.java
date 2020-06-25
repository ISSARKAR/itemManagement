package com.management.orderitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.orderitem.entity.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>{

}
