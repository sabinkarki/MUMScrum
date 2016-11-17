/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;

public interface ProductRepository {
	public void save(Product product);

	public List<Product> getProducts();

	public void update(Product product);

	public void delete(Long productId);

	public Product findById(Long id);
	
	public void addRelease(Release release,long ProductId);

}
