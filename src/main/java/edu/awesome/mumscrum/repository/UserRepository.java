/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author krishmanpradhan
 *
 */
public interface UserRepository {
	public void save(User user);

	public List<User> getUsers();

	public void update(User user);

	public void delete(Long userId);

	public User getUser(Long id);

}
