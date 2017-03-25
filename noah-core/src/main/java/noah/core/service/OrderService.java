package noah.core.service;

import java.util.List;

import noah.core.model.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Order saveOrder(Order order);
	Order getOrderById(Long id);
}
