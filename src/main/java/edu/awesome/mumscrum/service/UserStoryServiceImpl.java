/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.Date;
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
		userStory.setCreatedDate(new Date());
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

	@Override
	public List<UserStory> getProductBacklogByProductId(long productId) {
		return userStoryRepository.getProductBacklogByProductId(productId);
		
	}

	@Override
	public void addToRelease(long id, long releaseId) {
		userStoryRepository.addToRelease(id,releaseId);
		
	}

	@Override
	public List<UserStory> getReleaseBacklogByReleaseId(long releaseId) {
		// TODO Auto-generated method stub
		return userStoryRepository.getReleaseBacklogByReleaseId(releaseId);
	}

}
