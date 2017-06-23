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
import noah.web.form.ProductForm;
import noah.web.model.converter.ProductConverter;
import noah.web.view.ProductView;
import noah.web.view.RoastTypeView;
import noah.web.view.converter.ProductViewConverter;

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
	@Transactional
	@RequestMapping("/listAll")
	public List<ProductView> showAll() {
		List<Product> products = productService.getAllProducts();
		List<ProductView> productViews = productViewConverter.convert(products);
		return productViews;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping("/list/{categoryId}")
	public List<ProductView> showAllProducts(
			@PathVariable("categoryId") Integer categoryId) {
		List<Product> products = productService.getProductsByCategory(categoryId);
		List<ProductView> productViews = productViewConverter.convert(products);
		return productViews;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@RequestBody List<ProductForm> form) {
		
		System.out.println(form);
//		Product product = productConverter.convert(view);
//		productService.saveProduct(product);
//		
		return "success";
	}
	
	private List<ProductView> mockProduct(Integer category, Integer count) {
		List<ProductView> mockViews = Lists.newArrayList();
		
		for ( Integer i=0 ; i < count ; i++ ) {
			ProductView view = new ProductView();
			view.setId((long) (i+1));
			view.setCategory(category);
			if ( i%3 == 0 ) {
				view.setRoastTypes(mockRoastType(false));
			} else {
				view.setRoastTypes(mockRoastType(true));
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
	
	private List<RoastTypeView> mockRoastType(boolean mockFull) {
		List<RoastTypeView> cookTypeViews = Lists.newArrayList();
		
		RoastTypeView cookTypeView = new RoastTypeView();
		cookTypeView.setRoastTypeId(1);
		cookTypeView.setRoastTypeName("淺焙");
		cookTypeViews.add(cookTypeView);
		
		RoastTypeView cookTypeView2 = new RoastTypeView();
		cookTypeView2.setRoastTypeId(2);
		cookTypeView2.setRoastTypeName("中焙");
		cookTypeViews.add(cookTypeView2);
		
		if ( mockFull ) {
			RoastTypeView cookTypeView3 = new RoastTypeView();
			cookTypeView3.setRoastTypeId(3);
			cookTypeView3.setRoastTypeName("深焙");
			cookTypeViews.add(cookTypeView3);
		}
		
		return cookTypeViews;
	}
	
}
