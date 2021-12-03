package com.hcl.usecase.EmployeeService.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;
import com.hcl.usecase.EmployeeService.entity.Employee;
import com.hcl.usecase.EmployeeService.exception.EmployeeExistsException;
import com.hcl.usecase.EmployeeService.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO addEmployee(EmployeeDTO empDto) {
	
		Employee emp = empDto.prepareEmployeeEntity(empDto);
		Employee newEmp = employeeRepository.save(emp);
		EmployeeDTO dto = newEmp.prepareEmployeeDTO(newEmp);
		return dto;
	}

	public List<EmployeeDTO> getEmployees() {
		
		List<Employee> employeesList = employeeRepository.findAll();
		List<EmployeeDTO> employeesDtoList = employeesList.stream().map(x -> x.prepareEmployeeDTO(x)).collect(Collectors.toList());
		return employeesDtoList;
	}

	public void updateEmployee(EmployeeDTO empDto) {
		
		employeeRepository.update(empDto.getCode(), empDto.getName(), empDto.getGender(), empDto.getJobTitle(), empDto.getEmailId(), empDto.getExperience(), empDto.getPhoneNumber(), empDto.getLocation(), empDto.getProjectStatus());
		
	}

	public EmployeeDTO getEmployeeByCode(Long code) {
		return EmployeeDTO.valueOf(employeeRepository.getById(code));
		
	}

}
