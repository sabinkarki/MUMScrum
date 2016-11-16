/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Inject
	UserStoryService userStoryService;

	/**
	 * 
	 */
	public UserStoryServiceImpl() {
	}

	@Override
	public void save(UserStory userStory) {
		userStoryService.save(userStory);

	}

	@Override
	public List<UserStory> getUserStories() {
		return userStoryService.getUserStories();
	}

	@Override
	public void update(UserStory userStory) {
		userStoryService.update(userStory);
	}

	@Override
	public UserStory getUserStory(Long id) {
		return userStoryService.getUserStory(id);
	}

	@Override
	public void delete(Long userStoryId) {
		userStoryService.delete(userStoryId);
	}

}
