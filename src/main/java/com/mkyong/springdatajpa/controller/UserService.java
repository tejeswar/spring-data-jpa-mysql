package com.mkyong.springdatajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void insertDummyUsers() {
		User user1 = new User();
		user1.setFirstName("Hari");
		user1.setLastName("Sahu");
		user1.setAge(100);
		user1.setEmailId("Hari@gmail.com");
		
		User user2 = new User();
		user2.setFirstName("Rama");
		user2.setLastName("Pradhan");
		user2.setAge(200);
		user2.setEmailId("Rama@gmail.com");
		
		User user3 = new User();
		user3.setFirstName("Gopal");
		user3.setLastName("Biswal");
		user3.setAge(300);
		user3.setEmailId("Gopal@gmail.com");
		
		User user4 = new User();
		user4.setFirstName("Radhe");
		user4.setLastName("Jena");
		user4.setAge(400);
		user4.setEmailId("Radhe@gmail.com");
		
		User user5 = new User();
		user5.setFirstName("Hari");
		user5.setLastName("Sahu");
		user5.setAge(100);
		user5.setEmailId("Hari@gmail.com");
		
		User user6 = new User();
		user6.setFirstName("Rama");
		user6.setLastName("Pradhan");
		user6.setAge(200);
		user6.setEmailId("Rama@gmail.com");
		
		User user7 = new User();
		user7.setFirstName("Gopal");
		user7.setLastName("Biswal");
		user7.setAge(300);
		user7.setEmailId("Gopal@gmail.com");
		
		User user8 = new User();
		user8.setFirstName("Radhe");
		user8.setLastName("Jena");
		user8.setAge(400);
		user8.setEmailId("Radhe@gmail.com");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		
		userRepo.saveAll(users);
		System.out.println("All users got saved successfully...");
		
	}
	
	public List<User> getUsersBasedOnEmailidAndLastName(String emailId,String lastName){
		List<User> users = userRepo.findByEmailIdAndLastName(emailId, lastName);
		return  users;
	}
	
	public List<User> getUsersBasedOnEmailid(String emailId){
		//List<User> users = userRepo.findByEmailId(emailId);
		List<User> users = userRepo.findByEmailId123(emailId);
		return  users;
	}
	
	public List<User> getAllUsers(){	
		List<User> users = userRepo.getAllUsers456();
		return  users;
	}
	public List<User> getUsersByFirstName(String fname){	
		List<User> users = userRepo.getByFirstNameHello(fname);
		return  users;
	}
	
	public List<User> getUsersByAges(int age){	
		List<User> users = userRepo.getAllUsersByAge123(age);
		return  users;
	}
	
	public List<User> getUsersBySortedAgesAndLastName(int age){	
		
		Sort sort = Sort.by("age").ascending()
				  .and(Sort.by("lastName").descending());
		List<User> users = userRepo.findByAgeAndLastName(sort);
		return  users;
	}
	
	
}
