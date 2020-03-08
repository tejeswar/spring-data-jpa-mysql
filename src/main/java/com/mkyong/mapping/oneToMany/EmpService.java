package com.mkyong.mapping.oneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DeptRepo deptRepo;
	
	
	
	public void insertDummyEmpRecords() {
		
		Optional<Department> hrDept = deptRepo.findById(1l);
		Department hrDepartment = hrDept.get();
		
		Optional<Department> adminDept = deptRepo.findById(2l);
		Department adminDepartment = adminDept.get();
		
//		Optional<Department> hrDept = deptRepo.findById(1l);
//		Department hrDepartment = hrDept.get();
		
		Employee emp1 = new Employee("Hari", 12);
		
		
		
		Employee emp2 = new Employee("Gopal", 15);
		
		
		Employee emp3 = new Employee("Radhe", 10);
		
		
		Employee emp4 = new Employee("Lakshmi", 7);
		
		
		Employee emp5 = new Employee("Parvati", 19);
		
		
		
		Employee emp6 = new Employee("Shiva", 15);
		Employee emp7 = new Employee("Brahma", 23);
		
		
		//emp1.setDepartment(hrDepartment);
		////emp2.setDepartment(hrDepartment);
		//emp3.setDepartment(hrDepartment);
//		emp4.setDepartment(adminDepartment);
//		emp5.setDepartment(adminDepartment);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		
		empRepo.saveAll(employees);
		empRepo.saveAll(employees);
		System.out.println("All employees got inserted successfully...");
		
	}
	
	public List<Employee> getAllEmployees(){
		 Iterable<Employee> iterable = empRepo.findAll();
		
		List<Employee> allEmps  = StreamSupport
		.stream(iterable.spliterator(), false)
		.collect(Collectors.toList());
		//System.out.println(allEmps);
		return allEmps;
	}
	
}
