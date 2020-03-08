package com.mkyong.mapping.OneToOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.mapping.oneToMany.Department;


//https://download.oracle.com/otn-pub/jcp/persistence-2_1-fr-eval-spec/JavaPersistence.pdf
@RestController
public class PersonController {

	
	@Autowired
	private PersonService personService;
	
	//http://localhost:8080/insertDummyPersonRecords
	@RequestMapping(value = "/insertDummyPersonRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertPersons() {
		personService.insertDummyPersonRecords();;
		
		return new ResponseEntity<String>("All persons records inserted...", HttpStatus.OK);
	}
	//http://localhost:8080/deletePersonRecord/1
	@RequestMapping(value = "/deletePersonRecord/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePersonRecord(@PathVariable("id") long personId) {
		personService.deleteSinglePersonRecord(personId);
		
		return new ResponseEntity<String>("Person record got deleted successfully...", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllPersonss", method = RequestMethod.GET)
	public ResponseEntity<?> getAllPersonRecords() {
		List<Person> allPersons = personService.getAllPersons();
		
		return new ResponseEntity<>(allPersons, HttpStatus.OK);
	}
	
}
