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

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository {
	@Inject
	SessionFactory factory;

	/**
	 * 
	 */
	public ReleaseRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Release release) {
		Session session = factory.getCurrentSession();
		session.save(release);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Release> getReleases() {
		Session session = factory.getCurrentSession();
		List<Release> products = session.createQuery("from Release").list();
		session.close();
		return products;
	}

	@Override
	public void update(Release release) {
		Session session = factory.getCurrentSession();
		session.update(release);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long id) {
		Session session = factory.getCurrentSession();
		Release release = (Release) session.get(Release.class, id);
		if (release != null) {
			session.delete(release);
			session.flush();
		}
		session.close();
	}

	@Override
	public Release findById(Long id) {
		Session session = factory.getCurrentSession();
		Release release = (Release) session.get(Release.class, id);
		session.close();
		return release;
	}

	

}
