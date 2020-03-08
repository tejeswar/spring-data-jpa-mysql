package com.mkyong.mapping.ManyToOne;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.mapping.oneToMany.Department;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private UniversityRepo universityRepo;
	
	//for many-to-one unidirectional
	public void insertDummyStudentsAndUniversities() {
		
		University university1 = new University("CAMBRIDGE", "ENGLAND");
        University university2 = new University("OXFORD", "USA");
        universityRepo.saveAll(Arrays.asList(university1,university2));
		
		Student student1 = new Student("Sam","Disilva","Maths");
        Student student2 = new Student("Joshua", "Brill", "Science");
        Student student3 = new Student("Peter", "Pan", "Physics");
        student1.setUniversity(university1);
        student2.setUniversity(university1);
        student3.setUniversity(university1);
        
        Student student4 = new Student("XXX","Sahu","English");
        student4.setUniversity(university2);
        Student student5 = new Student("YYY", "Jena", "Mil");
        student5.setUniversity(university2);
        
        Set<Student> students = new HashSet<>();
        students.add(student1);students.add(student2);students.add(student3);
        students.add(student4);students.add(student5);      
        studentRepo.saveAll(students);
        
        
	}
	
	public List<Student> getAllStudents(){
		 Iterable<Student> iterable = studentRepo.findAll();
		
		List<Student> allStudents  = StreamSupport
		.stream(iterable.spliterator(), false)
		.collect(Collectors.toList());
		//System.out.println(allDepts);
		return allStudents;
	}
	
	public void insertSingleStudentRecord() {
		// to check optional=false functionality
		Student student1 = new Student("Optional","Sahu","History");
		 studentRepo.save(student1);
		
	}
}
