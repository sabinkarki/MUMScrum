/**
 * 
 */
package edu.awesome.mumscrum.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

/**
 * @author prabinadhikari
 *
 */
@Entity
public class Worklog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ElementCollection
	@CollectionTable
	@MapKeyColumn
	Map<Date, Double> dateAndEffortmap;

	public Worklog() {
		id = 1;
		dateAndEffortmap = new HashMap<>();
		dateAndEffortmap.put(new Date(), 25.0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Date, Double> getDateAndEffortmap() {
		return dateAndEffortmap;
	}

	public void setDateAndEffortmap(Map<Date, Double> dateAndEffortmap) {
		this.dateAndEffortmap = dateAndEffortmap;
	}

}
