package com.mkyong.mapping.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;
	
	public void insertDummySubjectRecords() {
		
//		Subject subject1 = new Subject("English", 15);
//		Subject subject2 = new Subject("Mil", 4);
//		Subject subject3 = new Subject("History", 10);
//		Subject subject4 = new Subject("Geology", 8);
//		Subject subject5 = new Subject("Math", 2);
		
	}
}
