/**
 * 
 */
package edu.awesome.mumscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author prabinadhikari
 *
 */
@Controller
public class SprintController {

	/**
	 * 
	 */
	

	@RequestMapping(value = { "/burndown" })
	public String burndown() {
	//	userStoryService.delete(id);
		return "burndowndisplay";

	}
	public SprintController() {
		// TODO Auto-generated constructor stub
	}

}
