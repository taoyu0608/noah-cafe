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
	 * 商品顯示的名稱
	 * */
	private String displayName;
	
	/**
	 * 商品價格
	 * */
	private BigDecimal unitPrice; 
	
}
