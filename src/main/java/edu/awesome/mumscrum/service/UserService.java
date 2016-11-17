/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.User;

/**
 * @author krishmanpradhan
 *
 */
public interface UserService {

	public void save(User user);

	public List<User> getUsers();

	public void update(User user);

	public void delete(Long userId);

	public User getUser(Long id);

}
