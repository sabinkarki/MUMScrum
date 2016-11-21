package edu.awesome.mumscrum.controller;

import javax.inject.Inject;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.UserStoryService;

@Controller
public class UserStoryController {
	@Inject
	private UserStoryService userStoryService;

	@RequestMapping(value = { "product/{productId}/userstory/new" }, method = RequestMethod.GET)
	public String newUserstory(@PathVariable long productId, Model model) {
		System.out.println("US GET");
		UserStory userStory = new UserStory();
		userStory.setProductId(productId);
		model.addAttribute("userStory", userStory);
		model.addAttribute("edit", false);

		// Map<Integer, String> developerMap = new TreeMap<>();
		// Map<Integer, String> testerMap = new TreeMap<>();

		// developerMap.put(1, "Jai");
		// developerMap.put(2, "Guru");
		// developerMap.put(3, "Dev");
		// testerMap.put(4, "TJai");
		// testerMap.put(5, "TGuru");
		// testerMap.put(6, "TDev");

		// model.addAttribute("developerMap", developerMap);
		// model.addAttribute("testerMap", testerMap);
		// model.addAttribute("today", new
		// SimpleDateFormat("MM/dd/yyyy").format(new Date()));

		return "userstoryform";

	}

	@RequestMapping(value = { "/product/{productId}/userstory/{id}/update" }, method = RequestMethod.GET)
	public String updateUserstory(@PathVariable long productId, @PathVariable long id, Model model) {
		UserStory userStory = userStoryService.getUserStory(id);
		model.addAttribute("userStory", userStory);
		model.addAttribute("edit", true);
		return "userstoryform";
	}

	@RequestMapping(value = { "/product/{productId}/userstory/{id}/update" }, method = RequestMethod.POST)
	public String updateUserstory(@PathVariable long productId, @PathVariable long id,
			@ModelAttribute("userstory") UserStory userStory, BindingResult result) {
		if (result.hasErrors()) {
			return "userstoryform";
		} else {
			userStoryService.update(userStory);
			;
			return "redirect:/product/" + productId;

		}

	}

	@RequestMapping(value = { "product/{productId}/userstory/new" }, method = RequestMethod.POST)
	public String createUserstory(@PathVariable long productId, @Valid UserStory userStory, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "userstoryform";
		} else {
			userStoryService.save(userStory);
			return "redirect:/product/" + productId;

		}
	}

	@RequestMapping(value = { "/movetorelease/userstory/{id}/release/{releaseId}" }, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void moveToRelease(@PathVariable long id, @PathVariable long releaseId) {
		userStoryService.addToRelease(id, releaseId);

	}

	@RequestMapping(value = { "effort/new" }, method = RequestMethod.GET)
	public String estimateEffort(Model model, @Valid UserStory userstory) {

		model.addAttribute("title", userstory.getTitle());
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
			/*
			 * userstoryService.save(userstory); return "redirect:/effort/" +
			 * userstory.getId();
			 */
			return "effortform";
		}

	}

	@RequestMapping(value = { "/developerUserStoryEffort" }, method = RequestMethod.GET)
	public String developerUserStoryeffort(Model model, UserStory userstory) {
		model.addAttribute("userstoryList", userStoryService.getUserStories());
		// sesssion user id to model attribute// model.addAttribute("userId",)
		return "effortlist";
	}

	@RequestMapping(value = { "/userstoryEffort/{id}/update" }, method = RequestMethod.GET)
	public String showEffort(@PathVariable long id, Model model) {
		UserStory userstory = userStoryService.getUserStory(id);
		model.addAttribute("userstory", userstory);
		return "effortform";
	}

	@RequestMapping(value = { "/userstoryEffort/update" }, method = RequestMethod.POST)
	public String updateEffort(@ModelAttribute("userstory") UserStory userStory, BindingResult result, Model model) {
		System.out.println("Good*****************************");
		UserStory userstoryTemp = userStoryService.getUserStory(userStory.getId());

		userstoryTemp.setEstimationgEffortForDeveloper(userStory.getEstimationgEffortForDeveloper());
		userstoryTemp.setEstimationgRemainingEffortForDeveloper(userStory.getEstimationgRemainingEffortForDeveloper());

		if (result.hasErrors()) {
			System.out.println("Has Error------------------->>>>>");
			return "effortform";
		} else {
			userStoryService.update(userStory);
			return "redirect:/home";
			
		}
	}

	@RequestMapping(value = { "delete/product/{productId}/userstory/{id}" })
	public String deleteUserStory(@PathVariable long productId, @PathVariable long id) {
		userStoryService.delete(id);
		return "redirect:/product/" + productId;

	}

	@RequestMapping(value = { "/product/{productId}/release/{releaseId}/userstory/{id}/remove" })
	public String removeFromRelease(@PathVariable long productId, @PathVariable long releaseId, @PathVariable long id) {
		userStoryService.removeFromRelease(id);
		return "redirect:/releasebacklog/product/" + productId + "/release/" + releaseId;
	}

}
