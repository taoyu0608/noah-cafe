package noah.core.dao;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noah.core.model.Product;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
public class ProductDaoUnitTest {

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testSave() {
		
		Product product = new Product();
		String coffeeName = "諾亞咖啡";
		product.setName(coffeeName);
		product.setUnitPrice(BigDecimal.valueOf(250));
		
		Product savedProduct = productDao.save(product);

		Assert.assertTrue(savedProduct.getId() > 0);
		Assert.assertEquals(coffeeName, savedProduct.getName());
	}
	
}
