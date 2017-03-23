package noah.core.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 商品名稱
	 * */
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 商品價格
	 * */
	@Column(name = "price", nullable = false)
	private BigDecimal price; 
	
}
