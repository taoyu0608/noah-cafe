package noah.core.service;

import noah.core.model.Product;
import java.util.List;

public interface ProductService {
	
	//Create
	Product saveProduct(Product product);
	//Retrieve
	Product getProductById(String productId);
	List<Product> getAllProducts();
	//Update
	Product editProduct(Product product);
	//Delete
	Product deleteProduct(Product product);
	//Utilities
	boolean exists(String productId);
}
