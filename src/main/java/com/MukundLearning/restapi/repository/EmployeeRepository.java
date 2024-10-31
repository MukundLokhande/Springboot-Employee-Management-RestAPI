package com.MukundLearning.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MukundLearning.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
