/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
public interface UserStoryService {

	public void save(UserStory userStory);

	public List<UserStory> getUserStories();

	public void update(UserStory userStory);

	public void delete(Long userStoryId);

	public UserStory getUserStory(Long id);

	public List<UserStory> getProductBacklogByProductId(long  productId);

	public void addToRelease(long id, long releaseId);

	public List<UserStory> getReleaseBacklogByReleaseId(long id);

}
