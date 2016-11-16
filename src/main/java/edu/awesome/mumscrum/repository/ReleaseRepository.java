/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Release;

public interface ReleaseRepository {
	public void save(Release release);

	public List<Release> getReleases();

	public void update(Release release);

	public void delete(Long id);

	public Release findById(Long id);


}
