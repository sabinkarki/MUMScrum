/**
 * 
 */
package edu.awesome.mumscrum.repository;

import edu.awesome.mumscrum.domain.Sprint;

/**
 * @author prabinadhikari
 *
 */
public interface SprintRepository {

	Sprint findSprintById(Long sprintId);

}
