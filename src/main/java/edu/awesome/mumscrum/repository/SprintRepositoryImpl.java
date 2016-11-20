/**
 * 
 */
package edu.awesome.mumscrum.repository;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.awesome.mumscrum.domain.Sprint;

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
	public Sprint findSprintById(Long sprintId) {
		Session session = sessionFactory.getCurrentSession();
		Sprint sprint = (Sprint) session.get(Sprint.class, sprintId);
		session.close();
		return sprint;
	}

}
