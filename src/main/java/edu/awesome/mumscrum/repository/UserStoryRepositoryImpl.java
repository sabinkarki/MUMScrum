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
		Session session = factory.openSession();
		session.update(userStory);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long userStoryId) {
		Session session = factory.getCurrentSession();
		UserStory userStory = (UserStory) session.get(UserStory.class, userStoryId);
		if (userStory != null) {
			session.delete(userStory);
			session.flush();
		}
		session.close();
	}

	@Override
	public UserStory getUserStory(Long id) {
		Session session = factory.openSession();
		UserStory userStory =(UserStory)session.get(UserStory.class,id);
		session.close();
		return userStory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserStory> getProductBacklogByProductId(long productId) {
		Session session = factory.openSession();
		Query query = session.createQuery(" from UserStory where productId= :productId AND releaseId=0");
        query.setParameter("productId", productId);
        return query.list();
		
	}
	
	

	@Override
	public void addToRelease(long id, long releaseId) {
		Session session = factory.openSession();
		UserStory userStory = (UserStory) session.get(UserStory.class, id);
		userStory.setReleaseId(releaseId);
		session.save(userStory);
		session.flush();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserStory> getReleaseBacklogByReleaseId(long releaseId) {
		Session session = factory.openSession();
		Query query = session.createQuery(" from UserStory where releaseId= :releaseId");
        query.setParameter("releaseId", releaseId);
        return query.list();
	}

	@Override
	public void removeFromRelease(long id) {
		Session session = factory.openSession();
		UserStory userStory = (UserStory) session.get(UserStory.class, id);
		userStory.setReleaseId(0);
		session.save(userStory);
		session.flush();
		
	}

}
