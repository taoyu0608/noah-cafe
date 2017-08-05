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

import com.google.common.collect.Lists;

import noah.core.domain.ProductDomain;
import noah.core.domain.RoastTypeDomain;
import noah.core.service.ProductService;
import noah.core.service.RoastTypeService;
import noah.web.form.ProductForm;
import noah.web.form.ProductFormWrapper;
import noah.web.form.ProductSelectedForm;
import noah.web.view.ProductView;
import noah.web.view.converter.ProductViewConverter;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RoastTypeService roastTypeService;
	
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
	public String saveProduct(@ModelAttribute("productFormWrapper") ProductFormWrapper productFormWrapper, RedirectAttributes model) {	
		List<ProductForm> productForms = productFormWrapper.getProductForm();
		
		List<ProductSelectedForm> productSelectedFormList = Lists.newArrayList();
		for(ProductForm productForm:productForms) {
			
			ProductSelectedForm productSelectedForm = new ProductSelectedForm();
			ProductDomain productDomain = productService.getProductDomainById(productForm.getProductId());
			RoastTypeDomain roastTypeDomain = roastTypeService.getRoastTypeDomainById(productForm.getRoastTypeId());
			Integer count = productForm.getCount();
			
			productSelectedForm.setProductDomain(productDomain);
			productSelectedForm.setRoastTypeDomain(roastTypeDomain);
			productSelectedForm.setCount(count);
			
			productSelectedFormList.add(productSelectedForm);
		}
		
		model.addFlashAttribute("selectedFormList", productSelectedFormList);
		return "redirect:/order/chosenList";
	}
	
}
