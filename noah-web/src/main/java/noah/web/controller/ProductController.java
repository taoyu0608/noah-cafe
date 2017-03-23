package noah.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import noah.core.model.Product;
import noah.core.service.ProductService;
import noah.web.converter.ProductViewConverter;
import noah.web.view.ProductView;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductViewConverter productViewConverter;
	
	@RequestMapping("/")
	public String indexPage() {
		return "noah-products";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<ProductView> showAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		List<ProductView> productViews = productViewConverter.convert(products);
		model.addAttribute("productViews", productViews);
		return productViews;
	}
	
}
