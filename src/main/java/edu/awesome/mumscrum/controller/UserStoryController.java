package edu.awesome.mumscrum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.UserStoryService;

@Controller
public class UserStoryController {
	@Inject
	private UserStoryService userStoryService;

	@RequestMapping(value = { "product/{productId}/userstory/new" }, method = RequestMethod.GET)
	public String newUserstory(@PathVariable long productId,Model model) {
		System.out.println("US GET");
		UserStory userStory = new UserStory();
		userStory.setProductId(productId);
		model.addAttribute("userStory", userStory);
		model.addAttribute("edit", false);

//		Map<Integer, String> developerMap = new TreeMap<>();
//		Map<Integer, String> testerMap = new TreeMap<>();

//		developerMap.put(1, "Jai");
//		developerMap.put(2, "Guru");
//		developerMap.put(3, "Dev");
//		testerMap.put(4, "TJai");
//		testerMap.put(5, "TGuru");
//		testerMap.put(6, "TDev");

//		model.addAttribute("developerMap", developerMap);
//		model.addAttribute("testerMap", testerMap);
		//model.addAttribute("today", new SimpleDateFormat("MM/dd/yyyy").format(new Date()));

		return "userstoryform";

	}

	@RequestMapping(value = { "product/{productId}/userstory/new" }, method = RequestMethod.POST)
	public String createUserstory(@PathVariable long productId, @ModelAttribute("userstory") UserStory userStory, BindingResult result,
			HttpServletRequest request) {

		// System.out.println(request.getParameter("users"));
//		System.out.println(request.getParameter("users0"));
//		System.out.println(request.getParameter("users1"));
//		System.out.println("US POST");
//		System.out.println(userstory.getId());
//		System.out.println(userstory.getTitle());
//		System.out.println(userstory.getContent());
//		System.out.println(userstory.getProductId());
		// List<User>users=new ArrayList<>();
		// users.add(e)
		// userstory.setUsers(users);
		if (result.hasErrors()) {
			return "userstoryform";
		} else {
			userStoryService.save(userStory);
			return "redirect:/product/" + productId;

		}
	}
	
	@RequestMapping(value = { "/movetorelease/userstory/{id}/release/{releaseId}" }, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void createUserstory(@PathVariable long id,@PathVariable long releaseId) {
		userStoryService.addToRelease(id,releaseId);
		
	}
	
	
	
	
	@RequestMapping(value = { "effort/new" }, method = RequestMethod.GET)
	public String estimateEffort(Model model,@Valid UserStory userstory) {
		
		model.addAttribute("title",userstory.getTitle());
		model.addAttribute("userstory", new UserStory());
		model.addAttribute("edit", false);
		return "effortform";

	}

	@RequestMapping(value = { "effort/new" }, method = RequestMethod.POST)
	public String createEffort(@Valid UserStory userstory, BindingResult result, ModelMap model, HttpSession session) {

		session.setAttribute("userstory", userstory);
		if (result.hasErrors()) {
			return "effortform";
		} else {
			/*userstoryService.save(userstory);
			return "redirect:/effort/" + userstory.getId();*/
			return "effortform";
		}

	}
	
	
	@RequestMapping(value = { "/developerUserStoryEffort" }, method = RequestMethod.GET)
	public String developerUserStoryeffort(Model model,@Valid UserStory userstory) {
		model.addAttribute("userstoryList", userStoryService.getUserStories());
		return "effortlist";
	}
	
	@RequestMapping("/userstoryEffort/{id}")
	public String showEffort(@PathVariable long id, Model model){
		UserStory userstory=userStoryService.getUserStory(id);
		System.out.println(userstory.getTitle());
		model.addAttribute("userstory", userstory);
		return "effortform";
		
	}
	
	@RequestMapping("/updateUS")
	public String updateUserStory(@PathVariable long id, Model model, UserStory userstory){
		
		
		userStoryService.save(userstory);
		
		return "redirect:/developerUserStoryEffort";
		
	}
	
}
