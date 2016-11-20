/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.Sprint;
import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.domain.Worklog;
import edu.awesome.mumscrum.repository.SprintRepository;

/**
 * @author prabinadhikari
 *
 */
@Service
public class SprintServiceImpl implements SprintService {
	@Inject
	private SprintRepository sprintRepository;

	/**
	 * 
	 */
	public SprintServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Double> getDataForBurnDownChart(Long sprintId) {
		Map<String, Double> burnDownDataMap = new TreeMap<String, Double>();
		Sprint sprint = sprintRepository.findSprintById(sprintId);
		for (UserStory story : sprint.getUserStories()) {
			Worklog worklog = story.getWorklog();
			Set<Entry<Date, Double>> entrySet = worklog.getDateAndEffortmap().entrySet();
			for (Entry<Date, Double> set : entrySet) {
				if (!burnDownDataMap.containsKey(set.getKey().toString()))
					burnDownDataMap.put(set.getKey().toString(), set.getValue());
				else {
					burnDownDataMap.put(set.getKey().toString(),
							burnDownDataMap.get(set.getKey().toString()) + set.getValue());
				}
			}

		}
		return burnDownDataMap;
	}

}
