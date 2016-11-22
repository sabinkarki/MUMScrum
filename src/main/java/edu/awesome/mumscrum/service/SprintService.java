package edu.awesome.mumscrum.service;

import java.util.List;
import java.util.Map;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;
import edu.awesome.mumscrum.domain.Sprint;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
public interface SprintService {

	Map<String, Double> getDataForBurnDownChart(Long sprintId);

	public void save(Sprint sprint);

	public List<Sprint> getSprints();

	public void update(Sprint sprint);

	public void delete(Long sprintId);

	public Sprint findById(Long id);
	
	public void addUserStory(UserStory userStory,long sprintId);
	
	public void removeUserStory(UserStory userStory,long sprintId);
}
