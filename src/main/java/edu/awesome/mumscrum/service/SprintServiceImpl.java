/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.Product;
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
		Sprint sprint = sprintRepository.findById(sprintId);
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

	@Override
	public void save(Sprint sprint) {
		// TODO Auto-generated method stub
		sprintRepository.save(sprint);
	}

	@Override
	public List<Sprint> getSprints() {
		// TODO Auto-generated method stub
		return sprintRepository.getSprints();
	}

	@Override
	public void update(Sprint sprint) {
		// TODO Auto-generated method stub
		sprintRepository.update(sprint);
	}

	@Override
	public void delete(Long sprintId) {
		// TODO Auto-generated method stub
		sprintRepository.delete(sprintId);
	}

	@Override
	public Sprint findById(Long id) {
		// TODO Auto-generated method stub
		Sprint sprint =sprintRepository.findById(id);
		return sprint;
	}

	@Override
	public void addUserStory(UserStory userStory, long sprintId) {
		// TODO Auto-generated method stub
		sprintRepository.addUserStory(userStory,sprintId);
	}

	@Override
	public void removeUserStory(UserStory userStory, long sprintId) {
		// TODO Auto-generated method stub
		sprintRepository.addUserStory(userStory,sprintId);
	}

}
