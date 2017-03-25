package noah.web.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import noah.core.model.Order;
import noah.core.model.OrderDetail;
import noah.web.view.OrderDetailView;
import noah.web.view.OrderView;

@Component
public class OrderDetailViewConverter {
	
	public OrderDetailView convert(OrderDetail source){
		OrderDetailView target = new OrderDetailView();
		target.setId(source.getId());
		target.setOid(source.getOid());
		//target.setProductName(source.getProductId())
		target.setUnitPrice(source.getUnitPrice());
		target.setDeliveryDate(source.getDeliveryDate());
		target.setDeliveredDate(source.getDeliveredDate());
		target.setRecievedDate(source.getReceivedDate());
		target.setMemo(source.getMemo());
		
		return target;
	}
	
	public List<OrderDetailView> convert(List<OrderDetail> sources){
		List<OrderDetailView> targets = new ArrayList<>();
		if(sources!=null & sources.size() > 0){
			Iterator<OrderDetail> it = sources.iterator();
			while(it.hasNext()){
				OrderDetailView temp = convert(it.next());
				targets.add(temp);
			}
		}
		return targets;
	}
}
