package com.mkyong.mapping.ManyToOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.mapping.oneToMany.Department;
import com.mkyong.mapping.oneToMany.DeptService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//localhost:8080/insertDummyUniversitiesAndStudentRecords
	@RequestMapping(value = "/insertDummyUniversitiesAndStudentRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertAllDepts() {
		studentService.insertDummyStudentsAndUniversities();;
		
		return new ResponseEntity<String>("All Universities and Students records inserted...", HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insertSingleStudentRecord", method = RequestMethod.GET)
	public ResponseEntity<?> insertSingleStudentRecord() {
	studentService.insertSingleStudentRecord();;
		
		return new ResponseEntity<>("Single record inserted successfully", HttpStatus.OK);
	}
}
