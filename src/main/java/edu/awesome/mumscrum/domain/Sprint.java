/**
 * 
 */
package edu.awesome.mumscrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author prabinadhikari
 *
 */
@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	private List<UserStory> userStories;
	private Date startDate;
	private Date endDate;

	/**
	 * 
	 */
	public Sprint() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<UserStory> getStories() {
		return userStories;
	}

	public void setStories(List<UserStory> stories) {
		this.userStories = stories;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
