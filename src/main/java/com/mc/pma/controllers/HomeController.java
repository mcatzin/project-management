package com.mc.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mc.pma.dao.EmployeeRepository;
import com.mc.pma.dao.ProjectRepository;
import com.mc.pma.entities.Employee;
import com.mc.pma.entities.Project;

@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		
		return "main/home";
	}
	
}
