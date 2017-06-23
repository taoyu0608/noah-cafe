package noah.web.form;

import lombok.Data;

@Data
public class ProductForm {
	private Long productId; 
	private int count;
	private Integer roastTypeId; 
}
