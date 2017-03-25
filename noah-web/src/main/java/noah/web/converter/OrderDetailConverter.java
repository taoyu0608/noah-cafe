package noah.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.OrderDetail;
import noah.core.service.OrderDetailService;
import noah.web.view.OrderDetailView;

@Component
@Transactional
public class OrderDetailConverter {
	@Autowired
	private OrderDetailService orderDetailService;
	
	public OrderDetail convert(OrderDetailView source){
		OrderDetail target = orderDetailService.getDetailById(source.getId());
		if(target == null){
			target.setId(source.getId());
			target.setOid(source.getOid());
			target.setPid(source.getPid());
			target.setMemo(source.getMemo());
			target.setDeliveryDate(source.getDeliverDate());
			target.setDeliveredDate(source.getDeliveredDate());
			target.setRecievedDate(source.getRecievedDate());
		}
		return target;
	}
}
