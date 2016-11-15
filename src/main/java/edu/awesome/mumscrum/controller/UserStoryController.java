package edu.awesome.mumscrum.controller;

import java.io.ObjectInputStream.GetField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.domain.UserStory;

@Controller
public class UserStoryController {
	@RequestMapping(value = { "userstory/new" }, method = RequestMethod.GET)
	public String newUserstory(Model model, HttpSession session) {
		System.out.println("US GET");
		model.addAttribute("userstory", new UserStory());
		model.addAttribute("edit", false);
		
		Map<Integer,String>developerMap=new TreeMap<>();
		Map<Integer,String>testerMap=new TreeMap<>();
		
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
	public String createUserstory(@ModelAttribute("userstory") UserStory userstory, BindingResult result, ModelMap model,
			HttpSession session,HttpServletRequest request) {
		
		//System.out.println(request.getParameter("users"));
		System.out.println(request.getParameter("users0"));
		System.out.println(request.getParameter("users1"));
		System.out.println("US POST");
		System.out.println(userstory.getId());
		System.out.println(userstory.getTitle());
		System.out.println(userstory.getCreatedDate());
		System.out.println();
		//List<User>users=new ArrayList<>();
		//users.add(e)
		//userstory.setUsers(users);
		session.setAttribute("userstory", userstory);
		if (result.hasErrors()) {
			return "userstoryform";
		} else {
			return "userstorylist";

		}
	}
}
