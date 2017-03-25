package noah.core.service;

import java.util.List;

import noah.core.model.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> getAllDetailsByOrderId(Long id);
	OrderDetail getDetailById(Long id);
	OrderDetail saveDetail(OrderDetail detail);
}
