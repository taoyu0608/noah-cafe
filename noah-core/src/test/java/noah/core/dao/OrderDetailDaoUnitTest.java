package noah.core.dao;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.Customer;
import noah.core.model.CustomerOrder;
import noah.core.model.OrderDetail;
import noah.core.model.Product;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
@Transactional
public class OrderDetailDaoUnitTest {
	
	@Autowired
	private CustomerOrderDao customerOrderDao;	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Test
	public void updateExistingDetail(){
		//Arrange
		Product product = new Product();
		String coffeeName = "諾亞咖啡";
		product.setName(coffeeName);
		product.setUnitPrice(BigDecimal.valueOf(250));
		product.setInStockQty(500);
		product.setDescription("好喝");
		
		Customer customer = new Customer();
		customer.setName("taoyu");
		customer.setEmail("taoyu@yahoo.com.tw");
		customer.setUsername("taoyu wu");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomer(customer);
		customerOrder.setOrderDate(new Date());
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setMemo("越快越好");
		orderDetail.setProduct(product);
		orderDetail.setCustomerOrder(customerOrder);
		orderDetail.setDeliveryDate(new GregorianCalendar(2017,3,15).getTime());
		orderDetail.setDeliveredDate(new GregorianCalendar(2017,3,15).getTime());
		orderDetail.setReceivedDate(new GregorianCalendar(2017,3,15).getTime());
		
		customerOrder.appendDetail(orderDetail);
		
		//Act
		customerOrderDao.save(customerOrder);
		
		orderDetail.setMemo("不用太快");
		orderDetail.setDeliveredDate(new GregorianCalendar(2017,3,16).getTime());
		OrderDetail updatedDetail = orderDetailDao.save(orderDetail);
		
		OrderDetail fetchedDetail = orderDetailDao.findOne(orderDetail.getId());
		
		//Assert
		Assert.assertEquals(updatedDetail, fetchedDetail);
	}

}
