package noah.core.service;

import java.util.List;

import noah.core.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(Long id);
	
	public void saveProduct(Product product);
}
