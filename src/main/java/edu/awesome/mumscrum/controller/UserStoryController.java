package edu.awesome.mumscrum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.UserStoryService;

@Controller
public class UserStoryController {
	@Inject
	private UserStoryService userStoryService;

	@RequestMapping(value = { "userstory/new" }, method = RequestMethod.GET)
	public String newUserstory(Model model) {
		System.out.println("US GET");
		model.addAttribute("userstory", new UserStory());
		model.addAttribute("edit", false);

		Map<Integer, String> developerMap = new TreeMap<>();
		Map<Integer, String> testerMap = new TreeMap<>();

		developerMap.put(1, "Jai");
		developerMap.put(2, "Guru");
		developerMap.put(3, "Dev");
		testerMap.put(4, "TJai");
		testerMap.put(5, "TGuru");
		testerMap.put(6, "TDev");

		model.addAttribute("developerMap", developerMap);
		model.addAttribute("testerMap", testerMap);
		model.addAttribute("today", new SimpleDateFormat("MM/dd/yyyy").format(new Date()));

		return "userstoryform";

	}

	@RequestMapping(value = { "userstory/new" }, method = RequestMethod.POST)
	public String createUserstory(@ModelAttribute("userstory") UserStory userstory, BindingResult result,
			HttpServletRequest request, HttpSession session) {

		// System.out.println(request.getParameter("users"));
		System.out.println(request.getParameter("users0"));
		System.out.println(request.getParameter("users1"));
		System.out.println("US POST");
		System.out.println(userstory.getId());
		System.out.println(userstory.getTitle());
		System.out.println(userstory.getCreatedDate());
		System.out.println();
		// List<User>users=new ArrayList<>();
		// users.add(e)
		// userstory.setUsers(users);
		session.setAttribute("userstory", userstory);
		if (result.hasErrors()) {
			return "userstoryform";
		} else {
			return "userstorylist";

		}
	}
}
