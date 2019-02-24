package com.noetic.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.noetic.employee.dao.DepartmentRepository;
import com.noetic.employee.entity.Department;
import com.noetic.employee.entity.Employee;
import com.noetic.employee.services.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	EmployeeService employeeService;
	DepartmentRepository departmentRepository;
	@Autowired
	public EmployeeController(EmployeeService employeeService, DepartmentRepository departmentRepository) {
		this.employeeService = employeeService;
		this.departmentRepository = departmentRepository;
	}
	
	@PostMapping(value="")
	@ResponseBody
	public Employee store(Employee employee) {
		employee.setFirstName("Hiruki");
		employee.setLastName("Anagipura");
		employee.setDepartment((Department)departmentRepository.findById(1).get());
		Employee savedEmployee = employeeService.save(employee);
		return savedEmployee;
				
	}
	
	@GetMapping(value="/list")
	@ResponseBody
	public List<Employee> index(Model model) {
		Iterable employeeList = employeeService.findAllEmployee();
		return (List<Employee>) employeeList;
        
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String remove (@PathVariable int id) {
		Employee deletedEmployee = employeeService.getEmployeeById(1).get();
		employeeService.removeEmployee(deletedEmployee);
		return "deleted the employee";
				
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Employee update(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(1).get();
		employee.setFirstName("Manushika");
	    Employee updatedEmployee = employeeService.save(employee);
		return updatedEmployee;
				
	}
	
	
	
	

}
