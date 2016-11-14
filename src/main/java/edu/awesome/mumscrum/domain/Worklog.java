/**
 * 
 */
package edu.awesome.mumscrum.domain;

import java.util.Date;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.collections.map.HashedMap;

/**
 * @author prabinadhikari
 *
 */
// @Entity
public class Worklog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	String storyID;
	String productID;
	Map<Date, Double> storyWorklogMap;
	Map<String, Map<Date, Double>> sprintWorkligMap;
	Map<String, Map<String, Map<Date, Double>>> releaseWorklogMap;

	/**
	 * 
	 */
	public Worklog() {
		storyWorklogMap = new HashedMap();
		sprintWorkligMap = new HashedMap();
		releaseWorklogMap = new HashedMap();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

}
