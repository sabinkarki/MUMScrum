/**
 * 
 */
package edu.awesome.mumscrum.repository;

import java.util.List;

import edu.awesome.mumscrum.domain.Product;
import edu.awesome.mumscrum.domain.Sprint;
import edu.awesome.mumscrum.domain.UserStory;

/**
 * @author prabinadhikari
 *
 */
public interface SprintRepository {

	void save(Sprint sprint);

	List<Sprint> getSprints();

	void update(Sprint sprint);

	void delete(Long sprintId);

	Sprint findById(Long id);

	void addUserStory(UserStory userStory, long sprintId);

}
