/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.UserStory;

public interface UserStoryRepository {
	public void save(UserStory userStory);

	public List<UserStory> getUserStories();

	public void update(UserStory userStory);

	public void delete(Long userStoryId);

	public UserStory getUserStory(Long id);

	public List<UserStory> getProductBacklogByProductId(long productId);

	public void addToRelease(long id, long releaseId);

	public List<UserStory> getReleaseBacklogByReleaseId(long releaseId);

	public void removeFromRelease(long id);

}
