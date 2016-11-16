/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
public interface UserStoryRepository {
	public void save(UserStory userStory);

	public List<UserStory> getUserStories();

	public void update(UserStory userStory);

	public void delete(Long userStoryId);

	public UserStory getUserStory(Long id);

}
