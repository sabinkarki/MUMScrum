/**
 * 
 */
package edu.awesome.mumscrum.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.service.SprintService;
import edu.awesome.mumscrum.service.UserStoryService;

/**
 * @author prabinadhikari
 *
 */
@RestController
public class SprintController {
	@Inject
	private SprintService sprintService;
	
	
	/**
	 * 
	 */

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
