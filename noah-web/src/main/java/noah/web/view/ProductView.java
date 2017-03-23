package noah.web.view;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductView {

	private Long id;
	
	/**
	 * 商品名稱
	 * */
	private String name;
	
	/**
	 * 商品價格
	 * */
	private BigDecimal price; 
	
}
