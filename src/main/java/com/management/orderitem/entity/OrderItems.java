package com.management.orderitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="order_items")
public class OrderItems {
	
	@Id
	private String productCode;
	private String productName;
	private Integer quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItems [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	public OrderItems() {
		super();
		this.productCode = "";
		this.productName = "";
		this.quantity = 0;
	}

}
