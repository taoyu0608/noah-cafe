package noah.web.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.Order;
import noah.core.model.OrderDetail;
import noah.core.model.Product;
import noah.web.view.OrderDetailView;

@Component
@Transactional
public class OrderDetailViewConverter {

	public OrderDetailView convert(OrderDetail source) {
		
		OrderDetailView target = new OrderDetailView();
		target.setId(source.getId());
		Order order = source.getOrder();
		target.setOId(order.getId());
		Product product = source.getProduct();
		target.setProductName(product.getName());
		target.setUnitPrice(product.getUnitPrice());
		target.setDeliveryDate(source.getDeliveryDate());
		target.setDeliveredDate(source.getDeliveredDate());
		target.setReceivedDate(source.getReceivedDate());
		target.setMemo(source.getMemo());

		return target;
	}

	public List<OrderDetailView> convert(List<OrderDetail> sources) {
		List<OrderDetailView> targets = new ArrayList<>();
		if ( CollectionUtils.isNotEmpty(sources) ) {
			Iterator<OrderDetail> it = sources.iterator();
			while (it.hasNext()) {
				OrderDetailView temp = convert(it.next());
				targets.add(temp);
			}
		}
		return targets;
	}
}
