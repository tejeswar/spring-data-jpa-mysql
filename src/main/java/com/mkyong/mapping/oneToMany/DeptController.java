package com.mkyong.mapping.oneToMany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
 INSERT INTO `transaction`.`Department` (`id`) VALUES ('5');
 
 CREATE TABLE `Department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

 */


@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	//localhost:8080/insertDummyDeptAndEmpRecords
	@RequestMapping(value = "/insertDummyDeptAndEmpRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertAllDepts() {
		deptService.insertDummyDepartmentsAndEmployeeRecords();
		
		return new ResponseEntity<String>("All deptments records inserted...", HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDeptRecords() {
		List<Department> allDepts = deptService.getAllDepartments();
		
		return new ResponseEntity<>(allDepts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllDepartmentsByNames/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDeptRecords(@PathVariable("name") String deptName) {
		List<Department> allDepts = deptService.getDeptsByName(deptName);
		
		return new ResponseEntity<>(allDepts, HttpStatus.OK);
	}
}
