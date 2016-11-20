/**
 * 
 */
package edu.awesome.mumscrum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author prabinadhikari
 *
 */
@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserStory> userStories;

	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	@Temporal(value = TemporalType.DATE)
	private Date endDate;

	/**
	 * 
	 */
	public Sprint() {
		// TODO Auto-generated constructor stub

		this.setId(1L);
		Date date1 = new Date(2016, 11, 20);
		this.setEndDate(date1);
		Date date = new Date(2016, 11, 19);
		this.setStartDate(date);
		Worklog worklog = new Worklog();
		UserStory userStory1 = new UserStory();
		userStory1.setId(1);
		userStory1.setWorklog(worklog);
		UserStory userStory2 = new UserStory();
		userStory2.setId(2);
		userStory2.setWorklog(worklog);
		List<UserStory> stories = new ArrayList<>();
		stories.add(userStory1);
		stories.add(userStory2);
		this.setUserStories(stories);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
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
