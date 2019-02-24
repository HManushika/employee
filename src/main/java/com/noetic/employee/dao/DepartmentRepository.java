package com.noetic.employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noetic.employee.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {


}
