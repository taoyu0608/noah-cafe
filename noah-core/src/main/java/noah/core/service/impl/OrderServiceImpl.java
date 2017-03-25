package noah.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noah.core.dao.OrderDao;
import noah.core.model.Order;
import noah.core.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderDao.findOne(id);
	}
	
}
