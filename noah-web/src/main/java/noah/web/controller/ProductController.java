package noah.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import noah.web.view.CookTypeView;
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
	@RequestMapping("/list/{category}")
	public List<ProductView> showAllProducts(
			@PathVariable("category") Integer category) {
//		List<Product> products = productService.getAllProducts();
//		List<ProductView> productViews = productViewConverter.convert(products);
//		model.addAttribute("productViews", productViews);
//		return productViews;
		
		Double count = (Double) (Math.random() * 5);
		List results = mockProduct(category, count.intValue() +2);
		System.err.println(results);
		return results;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@RequestBody ProductView view) {
		
		Product product = productConverter.convert(view);
		productService.saveProduct(product);
		
		return "success";
	}
	
	private List<ProductView> mockProduct(Integer category, Integer count) {
		List<ProductView> mockViews = Lists.newArrayList();
		
		for ( Integer i=0 ; i < count ; i++ ) {
			ProductView view = new ProductView();
			view.setId((long) (i+1));
			view.setCategory(category);
			if ( i%3 == 0 ) {
				view.setCookTypes(mockCookType(false));
			} else {
				view.setCookTypes(mockCookType(true));
			}
			view.setDisplayName("咖啡品牌＿" + i);
			view.setName("品牌_" + i);
			if ( i%3 == 0 ) {
				view.setUnitPrice(BigDecimal.valueOf(200));
			} else {
				view.setUnitPrice(BigDecimal.valueOf(250));
			}
			Integer imgIndex = (i+1);
			view.setImageName(imgIndex.toString());
			view.setImageDisplayName(i + "咖啡");
			
			mockViews.add(view);
		}
		
		System.err.println(mockViews);
		return mockViews;
	}
	
	private List<CookTypeView> mockCookType(boolean mockFull) {
		List<CookTypeView> cookTypeViews = Lists.newArrayList();
		
		CookTypeView cookTypeView = new CookTypeView();
		cookTypeView.setCookTypeId(1);
		cookTypeView.setCookTypeName("淺焙");
		cookTypeViews.add(cookTypeView);
		
		CookTypeView cookTypeView2 = new CookTypeView();
		cookTypeView2.setCookTypeId(2);
		cookTypeView2.setCookTypeName("中焙");
		cookTypeViews.add(cookTypeView2);
		
		if ( mockFull ) {
			CookTypeView cookTypeView3 = new CookTypeView();
			cookTypeView3.setCookTypeId(3);
			cookTypeView3.setCookTypeName("深焙");
			cookTypeViews.add(cookTypeView3);
		}
		
		return cookTypeViews;
	}
	
}
