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

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@Inject
	SessionFactory factory;

	/**
	 * 
	 */
	public ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Product product) {
		Session session = factory.getCurrentSession();
		session.save(product);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session session = factory.getCurrentSession();
		List<Product> products = session.createQuery("from Product").list();
		session.close();
		return products;
	}

	@Override
	public void update(Product product) {
		Session session = factory.getCurrentSession();
		session.update(product);
		session.flush();
		session.close();
	}

	@Override
	public void delete(Long productId) {
		Session session = factory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productId);
		if (product != null) {
			session.delete(product);
			session.flush();
		}
		session.close();
	}

	@Override
	public Product findById(Long id) {
		Session session = factory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.close();
		return product;
	}

}
