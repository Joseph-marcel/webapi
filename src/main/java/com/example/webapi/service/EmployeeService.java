package com.example.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapi.model.Employee;
import com.example.webapi.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeProxy employeeProxy;
	
	
	public Iterable<Employee> getEmployees(){
		return employeeProxy.getEmployees();
	}
	
	public Employee getEmployee(final int id) {
		return employeeProxy.getEmployee(id);
	}
	
	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;
		
		//Put employee last name in uppercase
		employee.setLastName(employee.getLastName().toUpperCase());
		
		if(employee.getId() == null) {
			savedEmployee = employeeProxy.createEmployee(employee);
		}else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}
		
		return savedEmployee;
	}

}
