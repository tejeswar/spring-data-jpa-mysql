package com.mkyong.mapping.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdharCardService {
	
	@Autowired
	private AdharCardRepo adharCardRepo;
	
	public List<AdharCard> getAllAdharCards(){
		Iterable<AdharCard>  iterable = adharCardRepo.findAll();
		List<AdharCard> allAdharCards  = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
		for(AdharCard adharCard : allAdharCards) {
			
			Person person = adharCard.getPerson();
			 System.out.println("Adhar No : "+adharCard.getAdharNo()+" # "+person.getName());
		}
				return allAdharCards;
	}
	
	

}
