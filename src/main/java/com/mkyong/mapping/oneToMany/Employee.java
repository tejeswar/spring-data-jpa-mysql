package com.mkyong.mapping.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

  
    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_age")
    private int age;
    
    //@Column(name = "dept_Id")//AnnotationException: @Column(s) not allowed on a @ManyToOne property: 
    //com.mkyong.mapping.oneToMany.Employee.department
    
    //In case u want to establish bidirectional mapping between Dept and Emp ,then enable the below annotations
//    @JsonIgnore   // to solve recursive issue in the post man
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "deptId")
//    private Department department;
    
//	public Department getDepartment() {
//	return department;
//}
//
//public void setDepartment(Department department) {
//	this.department = department;
//}

    public Employee() {
        super();
    }

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department.getDeptName() + "]";
//	}
    
    
    
    
}
