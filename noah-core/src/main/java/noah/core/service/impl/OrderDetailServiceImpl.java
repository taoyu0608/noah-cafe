package noah.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noah.core.dao.OrderDetailDao;
import noah.core.model.OrderDetail;
import noah.core.service.OrderDetailService;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	/**
	 * TODO:依訂單編號查所有的明細
	 */
	@Override
	public List<OrderDetail> getAllDetailsByOrderId(Long id) {
		return null;
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
