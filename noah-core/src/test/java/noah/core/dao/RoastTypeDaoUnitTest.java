package noah.core.dao;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.Product;
import noah.core.model.RoastType;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
@Transactional
public class RoastTypeDaoUnitTest {
	
	@Autowired
	private RoastTypeDao roastTypeDao;
	
	@Test
	public void testSave(){
		//Arrange
		RoastType roastType = new RoastType();
		
		Product p1 = new Product();
		p1.setName("產品1");
		p1.setUnitPrice(BigDecimal.valueOf(250));
		
		Product p2 = new Product();
		p2.setName("產品2");
		p2.setUnitPrice(BigDecimal.valueOf(450));
		
//		roastType.getProducts().add(p1);
//		roastType.getProducts().add(p2);
		//Act
		RoastType savedRoastType = roastTypeDao.save(roastType);
		
		//Assert
//		Assert.assertTrue(savedRoastType.getProducts().size() == 2);		
	}
	
//	@Test
//	public void testSelect(){
//		RoastType roastType = roastTypeDao.findOne(1L);
//		Assert.assertTrue(roastType.getProducts().size() == 2);
//		
//	}
}
