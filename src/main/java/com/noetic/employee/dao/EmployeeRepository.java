package com.noetic.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noetic.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
