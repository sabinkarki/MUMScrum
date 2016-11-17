/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.repository.UserRepository;

/**
 * @author krishmanpradhan
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;

	/**
	 * 
	 */
	public UserServiceImpl() {
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.getUser(id);
	}

	@Override
	public void delete(Long userId) {
		userRepository.delete(userId);
	}

}
