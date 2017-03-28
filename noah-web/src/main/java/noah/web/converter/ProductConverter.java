package noah.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import noah.core.model.Product;
import noah.core.service.ProductService;
import noah.web.view.ProductView;

@Component
@Transactional
public class ProductConverter {

	@Autowired
	private ProductService productService;
	
	public Product convert(ProductView source) {
		
		Product target = productService.getProductById(source.getId());
		if ( target == null ) {
			target = new Product();
		}
		
		target.setName(source.getName());
		target.setUnitPrice(source.getUnitPrice());
		
		return target;
	}
}
