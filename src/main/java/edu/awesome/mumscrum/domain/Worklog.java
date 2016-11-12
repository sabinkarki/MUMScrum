/**
 * 
 */
package edu.awesome.mumscrum.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author prabinadhikari
 *
 */
@Entity
public class Worklog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	String storyID;
	String releaseId;
	String productID;
	Date createdDate;
	Double estimationgRemainingEffortForDeveloper;
	Double estimationgRemainingEffortForTester;

	/**
	 * 
	 */
	public Worklog() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoryID() {
		return storyID;
	}

	public void setStoryID(String storyID) {
		this.storyID = storyID;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getEstimationgRemainingEffortForDeveloper() {
		return estimationgRemainingEffortForDeveloper;
	}

	public void setEstimationgRemainingEffortForDeveloper(Double estimationgRemainingEffortForDeveloper) {
		this.estimationgRemainingEffortForDeveloper = estimationgRemainingEffortForDeveloper;
	}

	public Double getEstimationgRemainingEffortForTester() {
		return estimationgRemainingEffortForTester;
	}

	public void setEstimationgRemainingEffortForTester(Double estimationgRemainingEffortForTester) {
		this.estimationgRemainingEffortForTester = estimationgRemainingEffortForTester;
	}

}
