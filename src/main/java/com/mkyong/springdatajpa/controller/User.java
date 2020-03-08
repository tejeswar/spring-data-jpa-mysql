package com.mkyong.springdatajpa.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//It is mandatory to use User. as part of the query name.else error
//@NamedQuery(name = "User.findByEmailId123", query = "select u from User u where u.emailId = ?1")






 

@NamedQuery(name = "User.findByEmailId123", query = "select u from User u where u.emailId = ?1")

@NamedQueries({
    @NamedQuery(name="User.getAllUsers456",
                query="SELECT c FROM User c"),
    @NamedQuery(name="User.getByFirstNameHello",
                query="SELECT c FROM User c WHERE c.firstName = :fname"),
})
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	private String firstName;
	private String lastName;
	
	private int age;
	private String emailId;
	
	public User() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
