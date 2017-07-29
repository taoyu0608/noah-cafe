package noah.core.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ProductDomain {

	/**
	 * The identity UUID for each product
	 */
	private Long id;

	/**
	 * The name for each product
	 */
	private String name;
	
	/**
	 * The image name for each product
	 */
	private String imageName;

	/**
	 * The price for each product
	 */
	private BigDecimal unitPrice;

	/**
	 * Simple description of product.
	 */
	private String description;

	/**
	 * Quantity of remaining inventory.
	 */
	private int inStockQty;
	
	/**
	 * The roast types
	 * */
	private List<RoastTypeDomain> roastTypes;
	
}
