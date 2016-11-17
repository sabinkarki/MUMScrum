/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;


public interface ReleaseService {

	public void save(Release release);

	public List<Release> getReleases();

	public void update(Release release);

	public void delete(Long id, long productId);

	public Release findById(Long id);


}
