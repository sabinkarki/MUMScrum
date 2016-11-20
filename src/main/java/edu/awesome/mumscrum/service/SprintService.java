package edu.awesome.mumscrum.service;

import java.util.Map;

/**
 * @author prabinadhikari
 *
 */
public interface SprintService {

	Map<String, Double> getDataForBurnDownChart(Long sprintId);

}
