package com.mkyong.mapping.OneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	private String name;
	private int age;
	
	//@OneToOne(cascade=CascadeType.PERSIST,orphanRemoval = true)
    //@JoinColumn(name = "adhar_id")   // one way of implementing one-to-one unidirectional relationship
	//@MapsId//another way of One-to-one unidirectional association where both source and target share the same primary key values. 
   @OneToOne
   @JoinColumn(name = "adhar_id")
   @JsonIgnore //it has nothing to do with mapping.Just to avoid the recursive calls in the post man we are using it.
	private AdharCard adharCard;

	public Person(String name, int age, AdharCard adharCard) {
		super();
		this.name = name;
		this.age = age;
		this.adharCard = adharCard;
	}
	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public AdharCard getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}
	
	
	
}
