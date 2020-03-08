package com.mkyong.mapping.oneToMany;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.springdatajpa.controller.User;

public interface DeptRepo extends CrudRepository<Department, Long>{

}
