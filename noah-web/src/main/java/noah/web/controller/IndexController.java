package noah.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Value("${mohw.version}")
	private String systemVersion;
	
	@RequestMapping("/")
	public String rootPage(Model model) {
		setupVersion(model);
System.err.println(1);
		return "index";
	}
	
	@RequestMapping("/products")
	public String productPage(Model model) {
		setupVersion(model);
		return "products";
	}
	
	private void setupVersion(Model model) {
		model.addAttribute("systemVersion", systemVersion);
	}
}
