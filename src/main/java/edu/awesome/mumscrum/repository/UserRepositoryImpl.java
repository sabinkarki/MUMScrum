/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author krishmanpradhan
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Inject
	private SessionFactory factory;

	/**
	 * 
	 */
	public UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(User user) {
		Session session = factory.getCurrentSession();
		session.save(user);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = factory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
		session.close();
		return users;
	}

	@Override
	public void update(User user) {
		Session session = factory.getCurrentSession();
		session.update(user);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long userId) {
		Session session = factory.getCurrentSession();
		Product product = (Product) session.get(Product.class, userId);
		if (product != null) {
			session.delete(product);
			session.flush();
		}
		session.close();
	}

	@Override
	public User getUser(Long id) {
		return null;
	}

}
