package noah.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Iterables;

import noah.core.model.Order;
import noah.core.model.OrderDetail;
import noah.core.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:test-spring-noah-core.xml")
public class OrderServiceUnitTest {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testSave() {
		
		Product product = new Product();
		String productName = "挪亞咖啡";
		product.setName(productName);
		product.setUnitPrice(BigDecimal.valueOf(250));
		product = productService.saveProduct(product);
		
		Order order = new Order();
		order.setUserName("taoyu");
		order.setOrderDate(new Date());
//		order.appendDetail(detail);
		Order savedOrder = orderService.saveOrder(order);
		
//		OrderDetail detail = new OrderDetail();
//		detail.setProduct(product);
//		Set<OrderDetail> savedDetails = savedOrder.getDetails();
//		OrderDetail topDetail = Iterables.getFirst(savedDetails, null);
//		Assert.assertNotNull(topDetail);
//		Assert.assertEquals(productName, topDetail.getProduct().getName());
	}
	
}
