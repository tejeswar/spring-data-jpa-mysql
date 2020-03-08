package com.mkyong.springdatajpa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/insertRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertAllUsers() {
		userService.insertDummyUsers();
		
		return new ResponseEntity<String>("All users records inserted...", HttpStatus.OK);
	}
	
	//http://localhost:8080/getUsersBasedOnEmailAndLastname/Hari@gmail.com?lastName=Sahu
	@RequestMapping(value = "/getUsersBasedOnEmailAndLastname/{emaiId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUsersBasedOnEmailAndLastname(@PathVariable("emaiId") String emailId,@RequestParam("lastName") String lastName) {
		System.out.println("User emailId :"+emailId +" And lastName is :"+lastName);
		
		List<User> users = userService.getUsersBasedOnEmailidAndLastName(emailId, lastName);
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//http://localhost:8080/getUsersBasedOnEmail/Hari@gmail.com
		@RequestMapping(value = "/getUsersBasedOnEmail/{emaiId}", method = RequestMethod.GET)
		public ResponseEntity<?> getUsersBasedOnEmail(@PathVariable("emaiId") String emailId) {
			System.out.println("User emailId :"+emailId);
			
			List<User> users = userService.getUsersBasedOnEmailid(emailId);
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		//http://localhost:8080/getAllUsers
		@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
		public ResponseEntity<?> getAllUsers() {
			
			
			List<User> users = userService.getAllUsers();
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}	
		//http://localhost:8080/getUsersByFirstName/Hari
		@RequestMapping(value = "/getUsersByFirstName/{fname1}", method = RequestMethod.GET)
		public ResponseEntity<?> getAllUsersByFirstName(@PathVariable("fname1") String firstName) {
			
			
			List<User> users = userService.getUsersByFirstName(firstName);
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}	
		//http://localhost:8080/getUsersByAge/200
		@RequestMapping(value = "/getUsersByAge/{age}", method = RequestMethod.GET)
		public ResponseEntity<?> getAllUsersByFirstName(@PathVariable("age") int age) {
			
			
			List<User> users = userService.getUsersByAges(age);
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
	
	
}
