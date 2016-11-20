/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author sabin
 *
 */
public interface UserRepository {
	List<User> findAllUser();

	public void update(User user);

	public void delete(Long user);

	public User getUser(Long id);

	public void save(User user);
	public User checkUsername(String username);

}
