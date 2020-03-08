package com.mkyong.async.models;

import java.util.List;

public class EmployeeNames {

	private List<EmployeeName> employeeNameList;

	public List<EmployeeName> getEmployeeNameList() {
		return employeeNameList;
	}

	public void setEmployeeNameList(List<EmployeeName> employeeNameList) {
		this.employeeNameList = employeeNameList;
	}

	public EmployeeNames(List<EmployeeName> employeeNameList) {
		super();
		this.employeeNameList = employeeNameList;
	}
	public EmployeeNames() {
		
	}
	
}
