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
	public void delete(Long userId) {
		Session session = factory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		if (user != null) {
			session.delete(user);
			session.flush();
		}
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
	}

	@Override
	public User checkUsername(String username) {
		Query query = factory.getCurrentSession().createQuery("from user where username = :username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}

}
