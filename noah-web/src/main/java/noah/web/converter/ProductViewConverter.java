package noah.web.converter;

import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.model.Product;
import noah.web.view.ProductView;

@Component
public class ProductViewConverter extends ModelConverter<Product, ProductView>{

	@Override
	protected ProductView mapping(Product source) {
		
		ProductView target = new ProductView();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDisplayName("[ " + source.getName() + " ]");
		target.setUnitPrice(source.getUnitPrice());
		
		return target;
	}
}
