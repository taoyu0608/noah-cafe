package noah.web.converter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import noah.core.model.Product;
import noah.web.view.ProductView;

@Component
public class ProductViewConverter {

	public ProductView convert(Product source) {
		
		ProductView target = new ProductView();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDisplayName("[ " + source.getName() + " ]");
		target.setPrice(source.getUnitPrice());
		
		return target;
	}
	
	public List<ProductView> convert(List<Product> sources) {
		
		if ( CollectionUtils.isEmpty(sources) ) {
			return Lists.newArrayList();
		}
		
		List<ProductView> targets = Lists.newArrayList();
		
		for (Product product : sources) {
			targets.add(this.convert(product));
		}
		
		return targets;
	}
}
