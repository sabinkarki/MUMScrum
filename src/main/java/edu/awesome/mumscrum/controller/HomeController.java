package edu.awesome.mumscrum.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
/*@RequestMapping(value = "/")*/
public class HomeController {
	@Inject
	private ProductService productService;
	
	@RequestMapping(value="/")
	public String getHome(){
		return "home";
	}
	
	@RequestMapping(value="/home")
	public String home(Model model) {
		List<Product> productList = productService.getProducts();
		if (productList.isEmpty()) {
			return "home";
		} else {
			Product product = productList.get(0);
			model.addAttribute("selectedProductId", product.getId());
			return "redirect:/product/" + product.getId();

		}


	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/403")
	public String pageNotFound() {
		return "404";
	}

	@RequestMapping(value = "/signup")
	public String signUpPage() {
		return "signup";
	}
}
