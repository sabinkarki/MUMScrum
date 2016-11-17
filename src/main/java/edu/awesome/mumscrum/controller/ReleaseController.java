package edu.awesome.mumscrum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;
import edu.awesome.mumscrum.service.ProductService;
import edu.awesome.mumscrum.service.ReleaseService;

@Controller
public class ReleaseController {

	@Inject
	ProductService productService;
	
	
	
	@RequestMapping(value = { "release/product/{productId}" }, method = RequestMethod.GET)
	public String release(@PathVariable long productId,Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product",product);
		model.addAttribute("selectedProductId",productId);
		return "releaselist";

	}

	@RequestMapping(value = { "product/{productId}/release/new" }, method = RequestMethod.GET)
	public String newProduct(@PathVariable long productId,Model model) {

		model.addAttribute("release", new Release());
		model.addAttribute("selectedProductId",productId);
		model.addAttribute("edit", false);
		return "releaseform";

	}

	@RequestMapping(value = { "product/{productId}/release/new" }, method = RequestMethod.POST)
	public String addRelease(@PathVariable long productId,@Valid Release release, BindingResult result, ModelMap model) {
		model.addAttribute("selectedProductId",productId);
		
		if (result.hasErrors()) {
			return "releaseform";
		} else {
			productService.addRelease(release, productId);
			System.out.println(release);
			return "redirect:/release/product/" + productId+"#release";

		}

	}
//	
//	@RequestMapping("/product/{id}")
//	public String showProduct(@PathVariable long id, Model model,HttpSession session){
//		model.addAttribute(productService.findById(id));
//		model.addAttribute("setSelected",true);
//		return "product";
//		
//	}
//	
//	@RequestMapping(value="/product/list", method =RequestMethod.GET)
//	public  String list(Model model){
//		model.addAttribute("productList",productService.getProducts());
//		return "productlist";
//		
//	}

}
