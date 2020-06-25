package com.management.orderitem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import lombok.Data;

@Entity
@Data
@Table(name="orders")@Proxy(lazy = false)
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Integer orderId;
	
	@NotBlank(message="Please provide a name")
	@Size(min=1, max=30)
	@Column(name="customer_name")
	private String customerName;
	
	@FutureOrPresent
	@Column(name="order_date")
	private Date orderDate;
	
	@NotBlank(message="Please provide a Shipping Address")
	@Size(min=1, max=100)
	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="total")
	private Double totalInDollars;
	
	@OneToMany
	private List<OrderItems> orderItems;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Double getTotalInDollars() {
		return totalInDollars;
	}

	public void setTotalInDollars(Double totalInDollars) {
		this.totalInDollars = totalInDollars;
	}

	public Order() {
		super();
		this.orderId = 0;
		this.customerName = "";
		this.orderDate = null;
		this.shippingAddress = "";
		this.totalInDollars = 0.0;
	}

	@Override
	public String toString() {
		return "Order [customerId=" + orderId + ", customerName=" + customerName + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", totalInDollars=" + totalInDollars + "]";
	}


	

}
