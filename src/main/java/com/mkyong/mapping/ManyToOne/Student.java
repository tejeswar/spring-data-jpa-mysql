package com.mkyong.mapping.ManyToOne;
//http://websystique.com/hibernate/hibernate-many-to-one-unidirectional-annotation-example/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
 
@Entity
@Table(name = "STUDENT")
public class Student {
 
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private long id;
    
    
    @ManyToOne(optional=false) //optional=false means this relationship becomes mandatory , no student row can be saved without a university tuple reference
    //@Fetch    // hibernate specific
    //@BatchSize(size = 10) // hibernate specific
    @JoinColumn(name="UNIVERSITY_ID") // @JoinColumn says that there is a column UNIVERSITY_ID in Student table which will refer(foreign key) to primary key of the University table
    private University university;
 
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @Column(name = "LAST_NAME")
    private String lastName;
 
    @Column(name = "SECTION")
    private String section;
 
   
 
 
    public Student() {
    }
 
    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
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
 
    public String getSection() {
        return section;
    }
 
    public void setSection(String section) {
        this.section = section;
    }
 
    public University getUniversity() {
        return university;
    }
 
    public void setUniversity(University university) {
        this.university = university;
    }
 
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", section=" + section + "]";
    }
 
}
