package noah.web.view.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.model.Product;
import noah.web.view.ProductView;
import noah.web.view.RoastTypeView;

@Component
public class ProductViewConverter extends ModelConverter<Product, ProductView> {

	@Autowired
	private RoastTypeViewConverter roastTypeViewConverter;
	
	@Override
	protected ProductView mapping(Product source) {

		ProductView target = new ProductView();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDisplayName("[ " + source.getName() + " ]");
		target.setUnitPrice(source.getUnitPrice());
		target.setImageName(source.getImageName());
		
		List<RoastTypeView> roastTypeViews = roastTypeViewConverter.convert(source.getRoastTypes());
		target.setRoastTypes(roastTypeViews);

		return target;
	}
}
