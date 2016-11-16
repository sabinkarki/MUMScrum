/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.UserStory;
import edu.awesome.mumscrum.repository.UserStoryRepository;

/**
 * @author prabinadhikari
 *
 */
@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Inject
	UserStoryRepository userStoryRepository;

	/**
	 * 
	 */
	public UserStoryServiceImpl() {
	}

	@Override
	public void save(UserStory userStory) {
		userStoryRepository.save(userStory);

	}

	@Override
	public List<UserStory> getUserStories() {
		return userStoryRepository.getUserStories();
	}

	@Override
	public void update(UserStory userStory) {
		userStoryRepository.update(userStory);
	}

	@Override
	public UserStory getUserStory(Long id) {
		return userStoryRepository.getUserStory(id);
	}

	@Override
	public void delete(Long userStoryId) {
		userStoryRepository.delete(userStoryId);
	}

}
