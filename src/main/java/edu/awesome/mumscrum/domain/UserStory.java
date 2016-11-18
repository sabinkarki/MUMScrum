package edu.awesome.mumscrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import edu.awesome.mumscrum.enums.Status;

@Entity
public class UserStory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String title;

	@NotBlank
	private String content;
	
	private long productId;
	
	private long releaseId;

	@Temporal(value = TemporalType.DATE)
	private Date createdDate;

	@OneToMany
	private List<User> users;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "estimationg_effort_for_developer")
	private Double estimationgEffortForDeveloper;
	@Column(name = "estimationg_effort_for_tester")
	private Double estimationgEffortForTester;
	@Column(name = "estimationg_remaining_effort_for_developer")
	private Double estimationgRemainingEffortForDeveloper;
	@Column(name = "estimationg_remaining_effort_for_tester")
	private Double estimationgRemainingEffortForTester;

	public UserStory() {
		// super();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getEstimationgEffortForDeveloper() {
		return estimationgEffortForDeveloper;
	}

	public void setEstimationgEffortForDeveloper(Double estimationgEffortForDeveloper) {
		this.estimationgEffortForDeveloper = estimationgEffortForDeveloper;
	}

	public Double getEstimationgEffortForTester() {
		return estimationgEffortForTester;
	}

	public void setEstimationgEffortForTester(Double estimationgEffortForTester) {
		this.estimationgEffortForTester = estimationgEffortForTester;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public long getReleaseId() {
		return releaseId;
	}


	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
	}
	
	


}
