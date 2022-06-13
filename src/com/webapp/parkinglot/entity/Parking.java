package com.webapp.parkinglot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parking")
public class Parking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy="parking")
	List<ParkingSpot> spaces;
	
	@Column(name="city")
	private String cityName;
	
	public List<ParkingSpot> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<ParkingSpot> spaces) {
		this.spaces = spaces;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setSpacesInTotal(int spacesInTotal) {
		this.spacesInTotal = spacesInTotal;
	}

	public void setFreeSpaces(int freeSpaces) {
		this.freeSpaces = freeSpaces;
	}

	public void setDisabledSpaces(int disabledSpaces) {
		this.disabledSpaces = disabledSpaces;
	}

	@Column(name="adress")
	private String adress;
	
	@Column(name="spaces_in_total")
	private int spacesInTotal;
	
	@Column(name="free_spaces")
	private int freeSpaces;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="disabled_spaces")
	private int disabledSpaces;

	@Column(name="price")
	private int price;
	
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
