package com.webapp.parkinglot.entity;

public class ReserveParking {
	
	public String getParkingAdress() {
		return parkingAdress;
	}
	public void setParkingAdress(String parkingAdress) {
		this.parkingAdress = parkingAdress;
	}
	public String getSpaceSignature() {
		return spaceSignature;
	}
	public void setSpaceSignature(String spaceSignature) {
		this.spaceSignature = spaceSignature;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	private String parkingAdress;
	private String spaceSignature;
	private String startDate;
	private String endDate;
	
	@Override
	public String toString() {
		return parkingAdress + ";" + spaceSignature;
	}

	
}
