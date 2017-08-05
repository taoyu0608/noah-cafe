package noah.web.form;

import lombok.Data;
import noah.core.domain.ProductDomain;
import noah.core.domain.RoastTypeDomain;

@Data
public class ProductSelectedForm {
	
	private ProductDomain productDomain;
	
	private RoastTypeDomain roastTypeDomain;
	
	private Integer count;
	
}
