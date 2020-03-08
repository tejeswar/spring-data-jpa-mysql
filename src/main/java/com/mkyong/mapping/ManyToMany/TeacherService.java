package com.mkyong.mapping.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	
	public void insertDummyTeacherRecords() {
		
		Subject subject1 = new Subject("English", 15);
		Subject subject2 = new Subject("Mil", 4);
		Subject subject3 = new Subject("History", 10);
		Subject subject4 = new Subject("Geology", 8);
		Subject subject5 = new Subject("Math", 2);
		
		List<Subject> listOfSujects = new ArrayList<>();
		listOfSujects.add(subject1);
		listOfSujects.add(subject2);
		listOfSujects.add(subject3);
		listOfSujects.add(subject4);
		listOfSujects.add(subject5);
		
		subjectRepo.saveAll(listOfSujects);//first save the child objects so that the ids will get generated
		
		List<Subject> listOfSujects1 = new ArrayList<>();
		listOfSujects1.add(subject1);
		listOfSujects1.add(subject2);
		listOfSujects1.add(subject3);
		Teacher teacher1 = new Teacher(listOfSujects1, "Raghunath", 45);
		
		List<Subject> listOfSujects2 = new ArrayList<>();
		listOfSujects2.add(subject3);
		listOfSujects2.add(subject4);
		Teacher teacher2 = new Teacher(listOfSujects2, "Ashok", 40);
		
		List<Subject> listOfSujects3 = new ArrayList<>();
		listOfSujects3.add(subject5);	
		Teacher teacher3 = new Teacher(listOfSujects3, "Ashish", 54);
		
		List<Teacher> listOfTeachers = new ArrayList<>();
		listOfTeachers.add(teacher1);
		listOfTeachers.add(teacher2);
		listOfTeachers.add(teacher3);
		
		teacherRepo.saveAll(listOfTeachers);
		System.out.println("All the teachers got saved...");
		
		
	}
	
	public List<Teacher> getAllTeachersWithSubjectUnidirectional(){
		 Iterable<Teacher> iterable = teacherRepo.findAll();
		
		List<Teacher> allTeachers  = StreamSupport
		.stream(iterable.spliterator(), false)
		.collect(Collectors.toList());
		
		return allTeachers;
	}
}
