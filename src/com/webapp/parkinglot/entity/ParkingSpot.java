package com.webapp.parkinglot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parking_spot")
public class ParkingSpot {
	
	@OneToMany(mappedBy="parkingSpot")
	private List<Reservation> spotsList;
		
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="space_name")
	private String spaceSignature;
	
	@ManyToOne
	@JoinColumn(name="parking_id")
	private Parking parking;
	
	public List<Reservation> getSpotsList() {
		return spotsList;
	}

	public void setSpotsList(List<Reservation> spotsList) {
		this.spotsList = spotsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpaceSignature() {
		return spaceSignature;
	}

	public void setSpaceSignature(String spaceSignature) {
		this.spaceSignature = spaceSignature;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public int getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(int isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getIsDisabledSpace() {
		return isDisabledSpace;
	}

	public void setIsDisabledSpace(int isDisabledSpace) {
		this.isDisabledSpace = isDisabledSpace;
	}

	@Column(name="is_occupied")
	private int isOccupied;
	
	@Column(name="is_disabled_space")
	private int isDisabledSpace;
	
}
