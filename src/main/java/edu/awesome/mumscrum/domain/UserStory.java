package edu.awesome.mumscrum.domain;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class UserStory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
/*	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "model_name")
	private String modelName;

	@ManyToOne(cascade = CascadeType.ALL)
	private AssetCategory assetcategory;*/
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@Column(name = "estimationg_effort_for_developer")
	private Double estimationgEffortForDeveloper;
	@Column(name = "estimationg_effort_for_tester")
	private Double estimationgEffortForTester;
	@Column(name = "estimationg_remaining_effort_for_developer")
	private Double estimationgRemainingEffortForDeveloper;
	@Column(name = "estimationg_remaining_effort_for_tester")
	private Double estimationgRemainingEffortForTester;
	@Column(name = "status")
	private int status;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	private User developer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User tester;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Release release;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Sprint sprint;
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;*/
	
	
	public UserStory() {
	//	super();
	}


}
