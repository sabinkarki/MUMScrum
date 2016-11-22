/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.awesome.mumscrum.domain.Sprint;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
@Repository
public class SprintRepositoryImpl implements SprintRepository {

	@Inject
	private SessionFactory sessionFactory;

	/**
	 * 
	 */
	public SprintRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprint findById(Long sprintId) {
		Session session = sessionFactory.getCurrentSession();
		Sprint sprint = (Sprint) session.get(Sprint.class, sprintId);
		//Hibernate.initialize(sprint.getUserStories());
		session.close();
		return sprint;
	}

	@Override
	public void save(Sprint sprint) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(sprint);
		session.close();
	}

	@Override
	public List<Sprint> getSprints() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Sprint> sprints=session.createQuery("from Sprint").list();
		session.close();
		return sprints;
	}

	@Override
	public void update(Sprint sprint) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.update(sprint);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long sprintId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Sprint sprint=(Sprint) session.get(Sprint.class, sprintId);
		if (sprint != null) {
			session.delete(sprint);
			session.flush();
		}
		session.close();
	}

	@Override
	public void addUserStory(UserStory userStory, long sprintId) {
		// TODO Auto-generated method stub
		
	}

}
