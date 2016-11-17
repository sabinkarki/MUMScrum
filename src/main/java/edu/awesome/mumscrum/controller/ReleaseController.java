package edu.awesome.mumscrum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.ProductService;
import edu.awesome.mumscrum.service.ReleaseService;
import edu.awesome.mumscrum.service.UserStoryService;

@Controller
public class ReleaseController {

	@Inject
	ProductService productService;
	
	@Inject
	UserStoryService userStoryService;
	
	@Inject
	ReleaseService releaseService;
	
	
	
	@RequestMapping(value = { "release/product/{productId}" }, method = RequestMethod.GET)
	public String release(@PathVariable long productId,Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product",product);
		model.addAttribute("selectedProductId",productId);
		model.addAttribute("selectedProductName",product.getName());
		return "releaselist";

	}
	
	@RequestMapping(value = { "/releasebacklog/product/{productId}/release/{id}" }, method = RequestMethod.GET)
	public String release(@PathVariable long productId,@PathVariable long id,Model model) {
		Product product = productService.findById(productId);
		Release release = releaseService.findById(id);
		List<UserStory> releaseBacklog = userStoryService.getReleaseBacklogByReleaseId(id); 
		model.addAttribute("release",release);
		model.addAttribute("releaseBacklog",releaseBacklog);
		model.addAttribute("selectedProductId",productId);
		model.addAttribute("selectedProductName",product.getName());
		return "release";

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
			return "redirect:/release/product/" + productId+"#release";

		}

	}
	
	@RequestMapping(value={"product/{productId}/release/{id}/update"}, method = RequestMethod.GET)
	public String update(@PathVariable long productId, @PathVariable long id, Model model) {
		Release release = releaseService.findById(id);
		model.addAttribute("release", release);
		model.addAttribute("selectedProductId",productId);
		model.addAttribute("edit", false);
		return "releaseform";

	}
	
	
	@RequestMapping(value={"product/{productId}/release/{id}/update"}, method = RequestMethod.POST)
	public String updateRelease(@PathVariable long productId,@Valid Release release, BindingResult result, ModelMap model) {
		model.addAttribute("selectedProductId",productId);
		if (result.hasErrors()) {
			return "releaseform";
		} else {
			releaseService.update(release);
			return "redirect:/release/product/" + productId+"#release";

		}

	}
	

	
	@RequestMapping(value={"product/{productId}/release/{id}/delete"})
	public String delete(@PathVariable long productId, @PathVariable long id){
		releaseService.delete(id,productId);
		return "redirect:/release/product/" + productId+"#release";
		
	}
	


}
