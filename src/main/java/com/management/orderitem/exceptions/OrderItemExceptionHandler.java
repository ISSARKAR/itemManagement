package com.management.orderitem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderItemExceptionHandler {
	@ExceptionHandler(value = OrderItemNotfoundException.class)
	public ResponseEntity<Object> exception(OrderItemNotfoundException exception) {
	      return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
	   }
}
