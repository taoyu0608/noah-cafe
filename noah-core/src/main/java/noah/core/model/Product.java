package noah.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{
	
	/**
	 * UID for serialization version control 
	 */
	private static final long serialVersionUID = 2L;
	
	/**
	 * The identity UUID for each product 
	 */
	@Id
	@Column(name = "PRODUCT_ID", length = 32, unique = true, nullable = false)
	private String productId;
	
	/**
	 * The name for each product
	 */
	@Column(name = "PRODUCT_NAME", length = 200, nullable = false)
	private String productName;
	
	/**
	 * The category for each product, i.e. how it's made/brand/kind.
	 */
	@Column(name = "PRODUCT_CATEGORY", length = 2, nullable = false)
	private String productCategory;
	
	/**
	 * The roast level for each product,e.g. light, medium, deep, dark.
	 */
	@Column(name = "PRODUCT_ROAST_LEVEL", length = 1, nullable = false)
	private int productRoastLevel;
	
	/**
	 * The price for each product
	 */
	@Column(name = "UNIT_PRICE", length = 10, nullable = false)
	private BigDecimal unitPrice;
	
	/**
	 * Simple description of product.
	 */
	@Column(name = "PRODUCT_DESCRIPTION", length = 200)
	private String productDescription;
	
	/**
	 * Quantity of remaining inventory.
	 */
	@Column(name = "PRODUCTS_IN_STOCK", length = 10, nullable = false)
    private int productsInStock;
}
