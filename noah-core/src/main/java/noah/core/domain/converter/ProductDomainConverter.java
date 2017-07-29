package noah.core.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.domain.ProductDomain;
import noah.core.model.Product;

@Component
public class ProductDomainConverter extends ModelConverter<Product, ProductDomain> {

	@Autowired
	private RoastTypeDomainConverter roastTypeDomainConverter;
	
	@Override
	protected ProductDomain mapping(Product source) {
		
		ProductDomain target = new ProductDomain();
		
		target.setId(source.getId());
		target.setImageName(source.getImageName());
		target.setDescription(source.getDescription());
		target.setInStockQty(source.getInStockQty());
		target.setName(source.getName());
		target.setUnitPrice(source.getUnitPrice());
		target.setRoastTypes(roastTypeDomainConverter.convert(source.getRoastTypes()));
		
		return target;
	}

}
