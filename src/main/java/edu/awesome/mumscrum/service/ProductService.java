/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;


public interface ProductService {

	public void save(Product product);

	public List<Product> getProducts();

	public void update(Product product);

	public void delete(Long productId);

	public Product findById(Long id);

}
