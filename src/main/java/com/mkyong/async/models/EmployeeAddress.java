package com.mkyong.async.models;

public class EmployeeAddress {

	private String houseNo;
	private String streetNo;
	private String zipCode;
	public EmployeeAddress(String houseNo, String streetNo, String zipCode) {
		super();
		this.houseNo = houseNo;
		this.streetNo = streetNo;
		this.zipCode = zipCode;
	}
	
	public EmployeeAddress() {}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	
}
