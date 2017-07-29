package noah.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import noah.core.domain.ProductDomain;
import noah.core.service.ProductService;
import noah.web.form.ProductFormWrapper;
import noah.web.view.ProductView;
import noah.web.view.converter.ProductViewConverter;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductViewConverter productViewConverter;
	
	@RequestMapping("/")
	public String indexPage() {
		return "products";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<ProductView> showAll() {
		List<ProductDomain> products = productService.getAllProductDomains();
		List<ProductView> productViews = productViewConverter.convert(products);
		return productViews;
	}
	
	@ResponseBody
	@RequestMapping("/list/category/{categoryId}")
	public List<ProductView> showAllProducts(
			@PathVariable("categoryId") Integer categoryId) {
		List<ProductDomain> products = productService.getProductDomainsByCategory(categoryId);
		List<ProductView> productViews = productViewConverter.convert(products);
		return productViews;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)	
	public String saveProduct(
			@ModelAttribute("productFormWrapper") ProductFormWrapper productFormWrapper, RedirectAttributes model) {		
		model.addFlashAttribute("selectedProducts", productFormWrapper.getProductForm());
		return "redirect:/product/chosenList";
	}
	
	@RequestMapping(value = "/chosenList", method = RequestMethod.GET)
	public String displayChosenList(){
		return "chosenList";
	}
	
}
