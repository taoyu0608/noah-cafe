package noah.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.Order;
import noah.core.service.OrderService;
import noah.web.view.OrderView;

@Component
@Transactional
public class OrderConverter {
	@Autowired
	private OrderService orderService;
	
	public Order convert(OrderView source){
		Order target = orderService.getOrderById(source.getId());
		if(target == null){
			target = new Order();
			target.setUserName(source.getUserName());
			target.setOrderDate(source.getOrderDate());
		}
		
		return target;
	}
}
