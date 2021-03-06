package noah.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	/**
	 * UID for serialization version control
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identity UUID for each product
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The name for each product
	 */
	@Column(name = "NAME", length = 200, nullable = false)
	private String name;
	
	/**
	 * The image name for each product
	 */
	@Column(name = "IMG_NAME", length = 50)
	private String imageName;

	/**
	 * The price for each product
	 */
	@Column(name = "UNIT_PRICE", length = 10, nullable = false)
	private BigDecimal unitPrice;

	/**
	 * Simple description of product.
	 */
	@Column(name = "DESCRIPTION", length = 200)
	private String description;

	/**
	 * Quantity of remaining inventory.
	 */
	@Column(name = "IN_STOCK_QTY", length = 10, nullable = false)
	private int inStockQty;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<RoastType> roastTypes;

}