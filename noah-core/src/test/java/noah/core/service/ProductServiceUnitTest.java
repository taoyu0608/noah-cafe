package noah.core.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noah.core.dao.CategoryDao;
import noah.core.dao.ProductDao;
import noah.core.model.Category;
import noah.core.model.Product;
import noah.core.model.search.condition.ProductSearchCondition;

@Rollback(value = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
public class ProductServiceUnitTest {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void testSpecification() {
		
		ProductSearchCondition condition = new ProductSearchCondition();
		Specification<Product> allTrue = new Specification<Product>() {
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.conjunction();
			}
		};
		Specifications<Product> conditions = Specifications.where(allTrue);
		conditions = conditions.and(condition.likeName("咖啡"));
		
		List<Product> products = productDao.findAll(conditions);
		for (Product product : products) {
			System.err.println(product);
		}
		
		
		Category c1 = new Category();
		c1.setName("咖啡粉");
		c1.setDescription("XXX");
		c1 = categoryDao.save(c1);
		
		c1.addProduct(products.get(0));
		c1.addProduct(products.get(1));
		categoryDao.save(c1);
	}
	
}
