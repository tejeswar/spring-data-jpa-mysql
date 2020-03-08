package com.mkyong.mapping.oneToMany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
 
INSERT INTO `transaction`.`employees` (`id`, `employee_age`, `employee_name`, `department_id`) VALUES ('8', '45', 'rty', '2');

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_age` int(11) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55h4q5s9h05x9ca1xjlw1ibyk` (`department_id`),
  CONSTRAINT `FK55h4q5s9h05x9ca1xjlw1ibyk` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci 
 

 */
@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "/insertDummyEmpRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertAllEmployees() {
		empService.insertDummyEmpRecords();
		
		return new ResponseEntity<String>("All employees records inserted...", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllEmpRecords", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmpRecords() {
		List<Employee> allEmployees = empService.getAllEmployees();
		
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
}
