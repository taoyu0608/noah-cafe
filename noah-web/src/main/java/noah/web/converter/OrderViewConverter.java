package noah.web.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import noah.core.model.Order;
import noah.web.view.OrderView;

@Component
public class OrderViewConverter {

	public OrderView convert(Order source) {
		OrderView target = new OrderView();
		target.setId(source.getId());
		target.setUserName(source.getUserName());
		target.setOrderDate(source.getOrderDate());

		if (source.isFinished())
			target.setFinishedText("已完成");
		else
			target.setFinishedText("未完成");

		return target;
	}

	public List<OrderView> convert(List<Order> sources) {
		List<OrderView> targets = new ArrayList<>();
		if (sources != null & sources.size() > 0) {
			Iterator<Order> it = sources.iterator();
			while (it.hasNext()) {
				OrderView temp = convert(it.next());
				targets.add(temp);
			}
		}
		return targets;
	}
}
