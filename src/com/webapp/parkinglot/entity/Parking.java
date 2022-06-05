package com.webapp.parkinglot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parking")
public class Parking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="adress")
	private String adress;
	
	@Column(name="spaces_in_total")
	private int spacesInTotal;
	
	@Column(name="free_spaces")
	private int freeSpaces;
	
	@Column(name="disabled_spaces")
	private int disabledSpaces;

	public String getCity() {
		return city;
	}

	public String getAdress() {
		return adress;
	}

	public int getSpacesInTotal() {
		return spacesInTotal;
	}

	public int getFreeSpaces() {
		return freeSpaces;
	}
	
	public int getDisabledSpaces() {
		return disabledSpaces;
	}
	
}
