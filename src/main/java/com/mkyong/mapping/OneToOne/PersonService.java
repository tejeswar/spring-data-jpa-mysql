package com.mkyong.mapping.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.mapping.oneToMany.Employee;

@Service
public class PersonService {

	
	@Autowired
	private AdharCardRepo adharCardRepo;
	@Autowired
	private PersonRepo personRepo;

	public PersonRepo getPersonRepo() {
		return personRepo;
	}

	public void setPersonRepo(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	public AdharCardRepo getAdharCardRepo() {
		return adharCardRepo;
	}


	public void setAdharCardRepo(AdharCardRepo adharCardRepo) {
		this.adharCardRepo = adharCardRepo;
	}


	
	
	public void insertDummyPersonRecords() {
		
		AdharCard adharCard1 = new AdharCard(111111, "Orissa");
		AdharCard adharCard2 = new AdharCard(222222, "Chennai");
		AdharCard adharCard3 = new AdharCard(333333, "Bangalore");
		
		List<AdharCard> listOfAdharCard = new ArrayList<>();
		listOfAdharCard.add(adharCard1);
		listOfAdharCard.add(adharCard2);
		listOfAdharCard.add(adharCard3);
		
		//adharCardRepo.saveAll(listOfAdharCard);
		
		
		Person person1 = new Person("xxx", 11, adharCard1);
		Person person2 = new Person("yyy", 22, adharCard2);
		Person person3 = new Person("zzz", 33, adharCard3);
		
		List<Person> listOfPersons = new ArrayList<>();
		listOfPersons.add(person1);
		listOfPersons.add(person2);
		listOfPersons.add(person3);
		personRepo.saveAll(listOfPersons);
		
		System.out.println("All person got inserted successfully...");
		
	}
	
	public void deleteSinglePersonRecord(long id) {
		personRepo.deleteById(id);
		System.out.println("Person got deleted with ID : "+id);
	}
	
	public List<Person> getAllPersons(){
		Iterable<Person>  iterable = personRepo.findAll();
		List<Person> allPersons  = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
		for(Person person : allPersons) {
			
			AdharCard adharCard = person.getAdharCard();
			 System.out.println("PersonName: "+person.getName()+" # "+adharCard.getAdharNo());
		}
				return allPersons;
	}
}
