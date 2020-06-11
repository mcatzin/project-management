package com.mc.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mc.pma.dao.EmployeeRepository;
import com.mc.pma.dao.ProjectRepository;
import com.mc.pma.dto.ChartData;
import com.mc.pma.dto.EmployeeProject;
import com.mc.pma.entities.Project;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber",ver);
		
		Map<String, Object> map = new HashMap<>();
		
		// we are querying the database for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();
		
		// Lets convert projectData object into json structure for use in JavaScript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		// we are querying the database for employees
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectCnt", employeesProjectCnt);
		
		return "main/home";
	}
	
}
