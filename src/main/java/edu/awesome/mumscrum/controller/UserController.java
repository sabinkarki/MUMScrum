package edu.awesome.mumscrum.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.enums.Role;
import edu.awesome.mumscrum.service.UserService;
import edu.awesome.mumscrum.validation.UserValidator;

/**
 * @author sabinkarki
 *
 */
@Controller
@SessionAttributes("msg")
public class UserController {
	@Inject
	private UserService userService;

	@InitBinder("userForm")
	protected void initUserBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage(@ModelAttribute("userForm") User user, Model modal) {
		List<Role> lstOfRoles = new ArrayList<Role>(Arrays.asList(Role.values()));
		modal.addAttribute(lstOfRoles);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userForm") User user, BindingResult result, Model modal,
			final RedirectAttributes redirect) {
		if (result.hasErrors()) {
			List<Role> lstOfRoles = new ArrayList<Role>(Arrays.asList(Role.values()));
			modal.addAttribute(lstOfRoles);
			return "register";
		}
		try {
			if (!userService.checkUsername(user.getUsername())) {

				String tempPassword = generateString();
				user.setPassword(tempPassword);
				userService.save(user);
				redirect.addFlashAttribute("users", userService.findAllUser());
				redirect.addFlashAttribute("success", true);
				return "redirect:/registerRedirect";
			} else {
				modal.addAttribute("errMsg", "UserName Already exist!");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "register";
	}

	@RequestMapping(value = "/registerRedirect", method = RequestMethod.GET)
	public String userList(Model model) {
		System.out.println(model.toString());
		return "userList";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		userService.delete(id);
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "userList";
	}

	public static String generateString() {
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 18) {
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;
	}

}
