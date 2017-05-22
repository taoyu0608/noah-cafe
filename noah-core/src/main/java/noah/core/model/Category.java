package noah.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{
	
	/**
	 * UID for serialization version control 
	 */
	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 類別名稱
	 */
	@Column(name ="NAME")
	private String name;
	
	/**
	 * 類別說明
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORY_PRODUCT", foreignKey = @ForeignKey(name = "FK_CATEGORY_PRODUCTS") )
	private List<Product> products = Lists.newArrayList();
	
	/**
	 * Add product to this category
	 * @param product
	 */
	public void addProduct(Product product){
		if(products != null){
			products.add(product);
		}
	}
}
