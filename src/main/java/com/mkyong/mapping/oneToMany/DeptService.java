package com.mkyong.mapping.oneToMany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeptService {

	@Autowired
	private DeptRepo deptRepo;
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	public void insertDummyDepartmentsAndEmployeeRecords() {
		
		
		// ONE TO MANY UNIDIRECTIONAL DATASET
		
		
		Department dept1 = new Department("HR");
		Department dept2 = new Department("Admin");
		Department dept3 = new Department("Finance");
		Department dept4 = new Department("Sanitary");
		
        Employee emp1 = new Employee("Hari", 12);
		Employee emp2 = new Employee("Gopal", 15);
		Employee emp3 = new Employee("Radhe", 10);
		Employee emp4 = new Employee("Lakshmi", 7);
		Employee emp5 = new Employee("Parvati", 19);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		empRepo.saveAll(employees);
		
        Set<Employee> empSet = new HashSet<>();
        empSet.add(emp1);
        empSet.add(emp2);
        empSet.add(emp3);
		dept1.setEmployees(empSet);
		
		List<Department> depts = new ArrayList<>();
		depts.add(dept1);
		depts.add(dept2);
		depts.add(dept3);
		depts.add(dept4);
		deptRepo.saveAll(depts);
		System.out.println("All depts got inserted successfully...");
		
		 
		
		/*
		 * ONE TO MANY BIDIRECTIONAL DATASET
		
		
		Department dept1 = new Department("HR");
		Department dept2 = new Department("Admin");
		Department dept3 = new Department("Finance");
		Department dept4 = new Department("Sanitary");
		
		List<Department> depts = new ArrayList<>();
		depts.add(dept1);
		depts.add(dept2);
		depts.add(dept3);
		depts.add(dept4);
		deptRepo.saveAll(depts);
		System.out.println("All depts got inserted successfully...");
		
        Employee emp1 = new Employee("Hari", 12);
		Employee emp2 = new Employee("Gopal", 15);
		Employee emp3 = new Employee("Radhe", 10);
		Employee emp4 = new Employee("Lakshmi", 7);
		Employee emp5 = new Employee("Parvati", 19);
		
		emp1.setDepartment(dept1);
		emp2.setDepartment(dept1);
		emp3.setDepartment(dept1);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		empRepo.saveAll(employees);
		*/
		
		
	}
	
	public List<Department> getAllDepartments(){
		 Iterable<Department> iterable = deptRepo.findAll();
		
		List<Department> allDepts  = StreamSupport
		.stream(iterable.spliterator(), false)
		.collect(Collectors.toList());
		//System.out.println(allDepts);
		return allDepts;
	}
	
	public List<Department> getDeptsByName(String name){
		List<Department> allDepts = (List<Department>) deptDao.loadDeptsByName(name);
		return allDepts;
	}
}
