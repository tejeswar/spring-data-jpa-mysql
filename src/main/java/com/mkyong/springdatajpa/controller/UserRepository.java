package com.mkyong.springdatajpa.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


//public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer>{
	
	  @Query("select u from User u where u.age > ?1")
	  List<User> getAllUsersByAge123(int age);
	  
	 List<User> findByAgeAndLastName(Sort sort);
	
	List<User> getByFirstNameHello(String fname);
	
	
	
	List<User> findByEmailIdAndLastName(String emailAddress, String lastname);
	
	
	
	
	List<User> findByEmailId123(String emailAddress);
	
	
	

	
    List<User> getAllUsers456();
	
	
	
}
