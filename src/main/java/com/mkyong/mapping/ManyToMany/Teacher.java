package com.mkyong.mapping.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/*
 In this example:
Entity Teacher references a collection of Entity Subject.
Entity Subject does not reference Entity Teacher.
Entity Teacher is the owner of the relationship.
 */
@Entity
public class Teacher {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
	
	@ManyToMany
	private List<Subject> subjects;
	
	private String name;
	private int age;
	public Teacher(List<Subject> subjects, String name, int age) {
		super();
		this.subjects = subjects;
		this.name = name;
		this.age = age;
	}
	public Teacher() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
