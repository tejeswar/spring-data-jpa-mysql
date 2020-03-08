package com.mkyong.async.models;

import java.util.List;

public class EmployeePhone {
	private List<String> PhoneNumbers;

	public List<String> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}

	public EmployeePhone(List<String> phoneNumbers) {
		super();
		PhoneNumbers = phoneNumbers;
	}
	
	public EmployeePhone() {
		
	}
}
