package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
	
}
