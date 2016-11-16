package edu.awesome.mumscrum.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.service.ProductService;

@Controller
public class ProductController {

	@Inject
	ProductService productService;

	@RequestMapping(value = { "product/new" }, method = RequestMethod.GET)
	public String newProduct(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("edit", false);
		return "productform";

	}

	@RequestMapping(value = { "product/new" }, method = RequestMethod.POST)
	public String createProduct(@Valid Product product, BindingResult result, ModelMap model, HttpSession session) {

		session.setAttribute("product", product);
		if (result.hasErrors()) {
			return "productform";
		} else {
			productService.save(product);
			return "redirect:/product/" + product.getId();

		}

	}
	
	@RequestMapping("/product/{id}")
	public String showProduct(@PathVariable long id, Model model,HttpSession session){
		Product product = productService.findById(id);

		model.addAttribute(product);


		model.addAttribute("setSelected",true);
		return "product";
		
	}
	
	@RequestMapping(value="/product/list", method =RequestMethod.GET)
	public  String list(Model model){
		model.addAttribute("productList",productService.getProducts());
		return "productlist";
		
	}

}
