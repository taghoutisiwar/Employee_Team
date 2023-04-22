package com.application.employee.team.Service;

import java.util.List;

import com.application.employee.team.Entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);

	List<Employee> getEmployees();
}
