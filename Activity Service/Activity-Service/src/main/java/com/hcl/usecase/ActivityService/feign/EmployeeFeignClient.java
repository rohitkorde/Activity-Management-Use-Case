package com.hcl.usecase.ActivityService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;

@FeignClient(name = "EmployeeMS/api")
public interface EmployeeFeignClient {
	
	@RequestMapping("/employee/{code}")
	EmployeeDTO viewEmployeeByCode(@PathVariable Long code);
	
	@RequestMapping("/employee")
	List<EmployeeDTO> viewAllEmployees();
	
}
	

