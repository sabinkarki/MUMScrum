package edu.awesome.mumscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.awesome.mumscrum.domain.Product;

@Controller
public class ProductController {
	
	@RequestMapping("product/new")
	public String newProduct(Model model){
		model.addAttribute("product",new Product());
		return "productform";
		
	}

}
