package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Order implements Serializable,Comparable<Order>{
	String username;
	String category;
	int orderCost;
	LocalDate dateOrder;
	String action;
	

	public Order() {
		super();
	}
	public Order(String username, String category, int orderCost, LocalDate dateOrder, String action) {
		super();
		this.username = username;
		this.category = category;
		this.orderCost = orderCost;
		this.dateOrder = dateOrder;
		this.action = action;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	public LocalDate getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "Username= " + username + ", Category= " + category + ", Cost=" + orderCost + ", Date= "
				+ dateOrder + ", Action= " + action ;
	}
	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return this.orderCost-o.getOrderCost();
	}
	
	



}
