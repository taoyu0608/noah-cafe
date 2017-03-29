package noah.core.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import noah.core.dao.OrderDetailDao;
import noah.core.model.Order;
import noah.core.model.OrderDetail;
import noah.core.service.OrderDetailService;
import noah.core.service.OrderService;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private OrderService orderService;

	@Override
	public List<OrderDetail> getAllDetailsByOrderId(Long id) {
		Order order = orderService.getOrderById(id);
		Set<OrderDetail> details = order.getOrderDetails();
		return Lists.newArrayList(details);
	}

	@Override
	public OrderDetail getDetailById(Long id) {
		return orderDetailDao.findOne(id);
	}

	@Override
	public OrderDetail saveDetail(OrderDetail detail) {
		return orderDetailDao.save(detail);
	}

}
