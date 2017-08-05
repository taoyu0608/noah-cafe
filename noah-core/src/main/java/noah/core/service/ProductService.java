package noah.core.service;

import java.util.List;

import noah.core.domain.ProductDomain;
import noah.core.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	List<ProductDomain> getAllProductDomains();
	
	List<Product> getProductsByCategory(Integer categoryId);
	
	List<ProductDomain> getProductDomainsByCategory(Integer categoryId);

	Product getProductById(Long id);
	
	ProductDomain getProductDomainById(Long id);

	Product saveProduct(Product product);
}
