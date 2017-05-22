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

import noah.core.model.Category;
import noah.core.model.Product;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-noah-core.xml")
@Transactional
public class CategoryDaoUnitTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void testSave(){
		//Arrange
		Category c = new Category();
		c.setName("濾掛");
		c.setDescription("就是掛在杯子上啊！");
		
		Product p1 = new Product();
		p1.setName("西雅圖濾掛式咖啡");
		p1.setDescription("好喝又便宜");
		p1.setUnitPrice(BigDecimal.valueOf(500));
		p1.setInStockQty(50);
		
		Product p2 = new Product();
		p2.setName("越南濾掛式咖啡");
		p2.setDescription("偏酸");
		p2.setUnitPrice(BigDecimal.valueOf(400));
		p2.setInStockQty(60);
		
		c.addProduct(p1);
		c.addProduct(p2);
		
		//Act
		Category savedCategory = categoryDao.save(c);
		
		//Assert
		Assert.assertEquals(2, savedCategory.getProducts().size());
		Assert.assertEquals(c,savedCategory);
	}
}
