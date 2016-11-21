/**
 * 
 */
package edu.awesome.mumscrum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.awesome.mumscrum.domain.Release;
import edu.awesome.mumscrum.repository.ReleaseRepository;

@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Inject
	ReleaseRepository releaseRepository;

	/**
	 * 
	 */
	public ReleaseServiceImpl() {
	}

	@Override
	public void save(Release release) {
		//product.setStartDate(new Date());
		releaseRepository.save(release);
	}

	@Override
	public List<Release> getReleases() {
		// TODO Auto-generated method stub
		return releaseRepository.getReleases();
	}

	@Override
	public void update(Release release) {
		releaseRepository.update(release);

	}

	@Override
	public void delete(Long id,long productId) {
		releaseRepository.delete(id,productId);

	}

	@Override
	public Release findById(Long id) {
		// TODO Auto-generated method stub
		return releaseRepository.findById(id);
		

	}

	

}
