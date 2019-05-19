package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.Order;

public class OrderRpository {
	List<Order> orders = new ArrayList<>();
	CarDepot car = new CarDepot();
	DealerRepository dealer = new DealerRepository();

	public OrderRpository() {
		Order orderNo1 = new Order();
		orderNo1.setCar(car.getCarFromDepo(11));
		orderNo1.setDealer(dealer.getDealer(1));
		orderNo1.setIdOrder(1001);
		Order orderNo2 = new Order();
		orderNo2.setCar(car.getCarFromDepo(12));
		orderNo2.setDealer(dealer.getDealer(2));
		orderNo2.setIdOrder(1002);

		orders.add(orderNo1);
		orders.add(orderNo2);

	}

	public List<Order> getOrders() {
		return orders;
	}

	public Order getOrder(int idOrder) {
		for (Order order : orders)
			if (order.getIdOrder() == idOrder) {
				return order;
			}
		return null;
	}

	public void createOrder(Order order) {
		orders.add(order);
	}
}