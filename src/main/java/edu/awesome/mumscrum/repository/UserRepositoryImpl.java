/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.awesome.mumscrum.domain.User;

/**
 * @author sabin
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Inject
	private SessionFactory factory;

	@Override
	public List<User> findAllUser() {
		Session session = factory.getCurrentSession();
		List<User> users = session.createQuery("from user").list();
		// session.close();
		return users;
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
		Session session = factory.getCurrentSession();
		session.save(user);
		// session.flush();
		// session.close();

	}

	@Override
	public User checkUsername(String username) {
		/*
		 * User user = (User) factory.getCurrentSession().get(User.class,
		 * username); return user;
		 */

		Query query = factory.getCurrentSession().createQuery("from user where username = :username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}

}
