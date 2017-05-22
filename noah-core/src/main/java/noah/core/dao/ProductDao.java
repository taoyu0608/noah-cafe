package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import noah.core.model.Product;

public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	
}
