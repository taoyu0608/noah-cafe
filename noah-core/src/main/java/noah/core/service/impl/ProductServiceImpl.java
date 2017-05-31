package noah.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noah.core.dao.CategoryDao;
import noah.core.dao.ProductDao;
import noah.core.model.Category;
import noah.core.model.Product;
import noah.core.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productDao.getOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return productDao.save(product);		
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) {
		
		Category category = categoryDao.getOne(categoryId);
		List<Product> products = category.getProducts();
		
		return products;
	}
}