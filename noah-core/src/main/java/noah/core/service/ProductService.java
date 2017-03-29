package noah.core.service;

import noah.core.model.Product;
import java.util.List;

public interface ProductService {
	
	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product saveProduct(Product product);
}
