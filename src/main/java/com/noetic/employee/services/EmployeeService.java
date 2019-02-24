package com.noetic.employee.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noetic.employee.dao.EmployeeRepository;
import com.noetic.employee.entity.Employee;

@Service
public class EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository =employeeRepository;
	}
	
	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	public Iterable findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(int i) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(i);
	}

	public void removeEmployee(Employee employee) {
		employeeRepository.delete(employee);
		
	}


}
