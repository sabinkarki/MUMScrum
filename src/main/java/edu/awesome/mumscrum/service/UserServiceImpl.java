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
 * @author sabin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Override
	public List<User> findAllUser() {
		return userRepository.findAllUser();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		return (userRepository.checkUsername(username)!=null);
	
	}

}
