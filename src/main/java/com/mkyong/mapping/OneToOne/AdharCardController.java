package com.mkyong.mapping.OneToOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdharCardController {
	
	@Autowired
	private AdharCardService adharCardService;
	@RequestMapping(value = "/getAllAdharCards", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAdharCards() {
		List<AdharCard> allAdharCards = adharCardService.getAllAdharCards();
		
		return new ResponseEntity<>(allAdharCards, HttpStatus.OK);
	}

}
