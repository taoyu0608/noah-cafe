package noah.web.form;

import lombok.Data;

@Data
public class ProductForm {
	/**
	 * 產品ID
	 */
	private Long productId;
	
	/**
	 * 數量
	 */
	private int count;
	
	/**
	 * 烘焙方式ID
	 */
	private Integer roastTypeId; 
}
