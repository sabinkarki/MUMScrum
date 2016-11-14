package edu.awesome.mumscrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(min=3, max=50)
	@Column(name ="name",nullable=false)
	private String name;
	
	//@NotNull
	//@Column(name ="startDate",nullable=false)
	private Date startDate;
	private List<UserStory> userStoryList;
	
	private List<Release> releaseList;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	public List<UserStory> getUserStoryList() {
		return userStoryList;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY)
	public List<Release> getReleaseList() {
		return releaseList;
	}
	
	
	

}
