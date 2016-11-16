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
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
@Repository
public class UserStoryRepositoryImpl implements UserStoryRepository {
	@Inject
	private SessionFactory factory;

	/**
	 * 
	 */
	public UserStoryRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(UserStory userStory) {
		Session session = factory.getCurrentSession();
		session.save(userStory);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserStory> getUserStories() {
		Session session = factory.getCurrentSession();
		List<UserStory> userStories = session.createQuery("from UserStory").list();
		session.close();
		return userStories;
	}

	@Override
	public void update(UserStory userStory) {
		Session session = factory.getCurrentSession();
		session.update(userStory);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long userStoryId) {
		Session session = factory.getCurrentSession();
		Product product = (Product) session.get(Product.class, userStoryId);
		if (product != null) {
			session.delete(product);
			session.flush();
		}
		session.close();
	}

	@Override
	public UserStory getUserStory(Long id) {
		return null;
	}

}
