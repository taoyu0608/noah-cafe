package noah.core.service;

import noah.core.model.Product;
import java.util.List;

public interface ProductService {
	public List<Product> getAllProducts();	
	public Product getProductById(Long id);	
	public void saveProduct(Product product);
}

