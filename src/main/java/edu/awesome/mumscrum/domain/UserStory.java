package edu.awesome.mumscrum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserStory {
	private long id;
	private String content;
	private long product;
	private long release;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	public long getProduct() {
		return product;
	}
	
	
	public void setProduct(long product) {
		this.product = product;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "release_id", nullable = false)
	public long getRelease() {
		return release;
	}
	
	
	

}
