package com.mkyong.mapping.oneToMany;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})//https://medium.com/@udith.indrakantha/issue-related-with-infinite-recursive-fetching-of-data-from-relationships-between-entity-classes-ffc5fac6c816
public class Department {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "dept_name")
    private String deptName;   

    //for bidirectional ,enable the below onetomany annotation
    //@OneToMany(mappedBy = "department",fetch = FetchType.LAZY) // mappedBy = "department" it means department field  owns the relationship and it is used only in case of bidirectional case
    //for unidirectional mapping ,enable the below onetomany annotation
    @OneToMany    
    //@JsonIgnore   //in case of bidirectional mapping,in the postman i am getting recursive respose resulting an error.so to overcome that issue,I am using it.
    
   // @JsonManagedReference
        private Set<Employee> employees;
    
    
    
    public Department() {
    	
    }

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", employees=" + employees.size() + "]";
	}
    
    
    
}
