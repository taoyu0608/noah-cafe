package noah.core.dao;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import noah.core.model.Product;

public interface ProductDao extends JpaRepository<Product, String>{
	
	/**
	 * Select by PRODUCT_ID
	 * @param productId
	 * @return
	 */
	public Product findByProductId(String productId);
	public List<Product> findByProductCategory(String productCategory);
	
	
	/**
	 * Update PRODUCT with specified values, and PRODUCT_ID as where condition.
	 * @param productId
	 * @param productName
	 * @param productCategory
	 * @param productRoastLevel
	 * @param unitPrice
	 * @param productDescription
	 * @param productsInStock
	 */
	@Query("UPDATE Product p"+
		   "SET    p.PRODUCT_NAME=?1,"+
		   "       p.PRODUCT_CATEGORY=?2,"+
		   "       p.PRODUCT_ROAST_LEVEL=?3,"+
		   "       p.UNIT_PRICE=?4,"+
		   "       p.PRODUCT_DESCRIPTION=?5,"+
		   "       p.PRODUCTS_IN_STOCK=?6")
	public void updateProduct(String productId, String productName, String productCategory, int productRoastLevel,
			BigDecimal unitPrice, String productDescription, int productsInStock);
	
	
	/**
	 * Delete product with specified PRODUCT_ID
	 * @param productId
	 */
	public void deleteProductByProductId(String productId);
}
