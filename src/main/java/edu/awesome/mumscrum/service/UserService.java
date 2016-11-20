/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.User;

/**
 * @author sabin
 *
 */
public interface UserService {

	List<User> findAllUser();

	public void update(User user);

	public void delete(Long user);

	public User getUser(Long id);

	public void save(User user);
	
	public boolean checkUsername(String username);

}
