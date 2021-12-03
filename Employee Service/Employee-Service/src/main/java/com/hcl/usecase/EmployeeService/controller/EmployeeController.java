package com.hcl.usecase.EmployeeService.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;
import com.hcl.usecase.EmployeeService.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {
	
		@Autowired
		private EmployeeService employeeService;
		
		@SuppressWarnings("rawtypes")
		@PostMapping("/employee/add")
		public ResponseEntity createEmployee(@Valid @RequestBody EmployeeDTO empbody){
			
			EmployeeDTO dto = employeeService.addEmployee(empbody);
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee " + dto.getCode() +  " Added successfully");
		}
		
		
		@GetMapping("/employee")
		public List<EmployeeDTO> viewAllEmployees(){
			 return employeeService.getEmployees();
		}
		
		@PatchMapping("/employee/edit")
		public ResponseEntity updateEmployee(@Valid @RequestBody EmployeeDTO empbody) {
			employeeService.updateEmployee(empbody);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee Edited Successfully");
		}
		
		@GetMapping("/employee/{code}")
		public EmployeeDTO viewEmployeeByCode(@Valid @NotNull @PathVariable Long code){
			return employeeService.getEmployeeByCode(code);
			
		}
}
