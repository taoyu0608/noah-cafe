package noah.core.service;

import noah.core.model.Product;
import java.util.List;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(Integer categoryId);

	Product getProductById(Long id);

	Product saveProduct(Product product);
}
