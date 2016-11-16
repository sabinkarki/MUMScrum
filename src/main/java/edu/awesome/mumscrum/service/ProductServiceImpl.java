/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductRepository productRepository;

	/**
	 * 
	 */
	public ProductServiceImpl() {
	}

	@Override
	public void save(Product product) {
		product.setStartDate(new Date());
		productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.getProducts();
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
		

	}

}
