/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;

/**
 * @author prabinadhikari
 *
 */
public interface ProductService {

	public void save(Product product);

	public List<Product> getProducts();

	public void update(Product product);

	public void delete(Long productId);

	public Product getProduct(Long id);

}
