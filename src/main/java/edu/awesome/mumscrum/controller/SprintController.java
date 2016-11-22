/**
 * 
 */
package edu.awesome.mumscrum.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;
import edu.awesome.mumscrum.domain.Sprint;
import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.SprintService;
import edu.awesome.mumscrum.service.UserStoryService;


@Controller
public class SprintController {
	@Inject
	private SprintService sprintService;
	
	
	/**
	 * @throws ParseException 
	 * 
	 */

	
	@RequestMapping(value = { "/sprint/new" }, method = RequestMethod.GET)
	public String newSprint(Model model) throws ParseException  {
		Sprint sprint=new Sprint();
		model.addAttribute("sprint",sprint );
		
		model.addAttribute("startDate",new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//Date endDate = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2000");
		model.addAttribute("endDate",new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		model.addAttribute("edit",false);
		return "sprintForm";
	}
	
	@RequestMapping(value = { "/sprint/new" }, method = RequestMethod.POST)
	public String newSprintPost(@Valid Sprint sprint, BindingResult result, ModelMap model)  {
	//System.out.println(sprint.getEndDate());
		if(sprint.getEndDate().compareTo(sprint.getStartDate())<0){
			model.addAttribute("dateError","End date lesser than startdate");
			return "sprintForm";
		}
		else {
			if (result.hasErrors()) {
				//sprintService.save(sprint);
				
				return "sprintForm";
			} else {
				sprintService.save(sprint);
				
				return "redirect:/sprint/";
			}
			
		}
	}
	
	@RequestMapping("/sprint")
	public String showSprints( Model model){
		Sprint sprint = new Sprint();
		List<Sprint> sprints = sprintService.getSprints(); 
		
		model.addAttribute("sprints",sprints);
		
		return "sprintList";
		
	}
	
	@RequestMapping(value={"/sprint/{id}/update"},method=RequestMethod.GET)
	public String updateSprint(@PathVariable long id, Model model){
		Sprint sprint = sprintService.findById(id);
		model.addAttribute("sprint", sprint);
		model.addAttribute("edit",true);
		return "sprintForm";
	}
	@RequestMapping(value={"/sprint/{id}/update"},method=RequestMethod.POST)
	public String updateSprintPOST( @PathVariable long id,@Valid Sprint sprint,ModelMap model,BindingResult result){
	if (result.hasErrors()) {
		return "sprintForm";
	} else {
		sprintService.update(sprint);
		return "redirect:/sprint/";

	}}
	
	@RequestMapping(value={"/sprint/{id}/delete"},method=RequestMethod.GET)
	public String deleteSprintPOST( @PathVariable long id){
			sprintService.delete(id);
			return "redirect:/sprint";
			
		}
	
	
		
	@RequestMapping(value = { "/burndown" })
	public String burndown() {
		// userStoryService.delete(id);
		return "burndowndisplay";

	}

	public SprintController() {

	}

	@RequestMapping(value = "/burndownchart", method = RequestMethod.GET)
	public Map<String, Double> getBurndownData() {
		System.out.println("this is test+++++++++++++++++");
		Map<String, Double> dataForBurnDownChartMaP = sprintService.getDataForBurnDownChart(1L);
		return dataForBurnDownChartMaP;
	}
	
	

}
