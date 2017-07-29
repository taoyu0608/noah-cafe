//package noah.web.model.converter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import noah.api.converter.ModelConverter;
//import noah.core.model.Product;
//import noah.core.service.ProductService;
//import noah.web.view.ProductView;
//
//@Component
//public class ProductConverter extends ModelConverter<ProductView, Product> {
//
//	@Autowired
//	private ProductService productService;
//	
//	@Override
//	protected Product mapping(ProductView source) {
//		
//		Product target = productService.getProductById(source.getId());
//		if ( target == null ) {
//			target = new Product();
//		}
//		
//		target.setName(source.getName());
//		target.setUnitPrice(source.getUnitPrice());
//		
//		return target;
//	}
//
//}
