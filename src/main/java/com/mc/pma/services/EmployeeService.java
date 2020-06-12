package com.mc.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.pma.dao.EmployeeRepository;
import com.mc.pma.dto.EmployeeProject;
import com.mc.pma.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProject(){
		return empRepo.employeeProjects();
	}
}
