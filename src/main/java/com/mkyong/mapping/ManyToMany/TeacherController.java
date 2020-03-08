package com.mkyong.mapping.ManyToMany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeacherController {

	
	@Autowired
	private TeacherService teacherService;
	
	//http://localhost:8080/insertDummyTeacherRecords
	@RequestMapping(value = "/insertDummyTeacherRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertAllTeachers() {
		teacherService.insertDummyTeacherRecords();
		
		return new ResponseEntity<String>("All teaches records got inserted...", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllTeachersUnidirectional", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTeachersUnidirectional() {
		List<Teacher> allTeachers = teacherService.getAllTeachersWithSubjectUnidirectional();
		
		return new ResponseEntity<>(allTeachers, HttpStatus.OK);
	}
}
