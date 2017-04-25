package noah.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import noah.core.model.Product;
import noah.core.service.ProductService;
import noah.web.converter.ProductConverter;
import noah.web.converter.ProductViewConverter;
import noah.web.view.ProductView;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ProductViewConverter productViewConverter;
	
	@RequestMapping("/")
	public String indexPage() {
		return "noah-products";
	}
	
	@ResponseBody
	@RequestMapping("/listAll")
	public List<ProductView> showAll() {
		List<Product> products = productService.getAllProducts();
		List<ProductView> productViews = productViewConverter.convert(products);
		return productViews;
	}
	
	@ResponseBody
	@RequestMapping("/list/{category}")
	public List<ProductView> showAllProducts(
			@PathVariable("category") Integer category) {
//		List<Product> products = productService.getAllProducts();
//		List<ProductView> productViews = productViewConverter.convert(products);
//		model.addAttribute("productViews", productViews);
//		return productViews;
		
		Double count = (Double) (Math.random() * 5);
		List results = mockProduct(category, count.intValue() +1);
		System.err.println(results);
		return results;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@Transactional
	public String saveProduct(@RequestBody ProductView view) {
		
		Product product = productConverter.convert(view);
		productService.saveProduct(product);
		
		return "success";
	}
	
	private List<ProductView> mockProduct(Integer category, Integer count) {
		List<ProductView> mockViews = Lists.newArrayList();
		
		for ( int i=0 ; i < count ; i++ ) {
			ProductView view = new ProductView();
			view.setId((long) (i+1));
			view.setCategory(category);
			if ( i%3 == 0 ) {
				view.setCookTypes(Lists.newArrayList(1, 2));
			} else {
				view.setCookTypes(Lists.newArrayList(1, 2, 3));
			}
			view.setDisplayName("咖啡品牌＿" + i);
			view.setName("品牌_" + i);
			if ( i%3 == 0 ) {
				view.setUnitPrice(BigDecimal.valueOf(200));
			} else {
				view.setUnitPrice(BigDecimal.valueOf(250));
			}
			
			mockViews.add(view);
		}
		
		return mockViews;
	}
}
