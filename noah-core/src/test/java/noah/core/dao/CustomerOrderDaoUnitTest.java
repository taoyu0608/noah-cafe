package noah.core.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noah.core.model.Customer;
import noah.core.model.CustomerOrder;
import noah.core.model.OrderDetail;
import noah.core.model.Product;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
public class CustomerOrderDaoUnitTest {
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Test
	public void testSave() {
		
		Product product = new Product();
		String coffeeName = "諾亞咖啡";
		product.setName(coffeeName);
		product.setUnitPrice(BigDecimal.valueOf(250));
		Product savedProduct = productDao.save(product);
		
		Customer customer = new Customer();
		customer.setName("taoyu");
		customer.setEmail("taoyu@yahoo.com.tw");
		customer.setUsername("taoyu wu");
		Customer savedCustomerer = customerDao.save(customer);
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomer(savedCustomerer);
		customerOrder.setOrderDate(new Date());
		CustomerOrder savedCustomerOrder = customerOrderDao.save(customerOrder);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setMemo("越快越好");
		orderDetail.setProduct(savedProduct);
		orderDetail.setCustomerOrder(savedCustomerOrder);
		orderDetailDao.save(orderDetail);
		
		savedCustomerOrder.appendDetail(orderDetail);
		savedCustomerOrder = customerOrderDao.save(customerOrder);
	}
	
}
