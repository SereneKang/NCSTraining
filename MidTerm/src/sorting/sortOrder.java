package sorting;

import java.util.Comparator;

import model.Order;

public class sortOrder implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		
		return o1.getOrderCost()-o2.getOrderCost();
	}
	

}
