package noah.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ implements Serializable {

	private static final long serialVersionUID = 1L;

	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, BigDecimal> unitPrice;
	public static volatile SingularAttribute<Product, Integer> inStockQty;

}