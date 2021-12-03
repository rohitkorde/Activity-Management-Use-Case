package com.hcl.usecase.EmployeeService.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.hcl.usecase.EmployeeService.entity.Employee;
	
@Component
public class EmployeeDTO {
		
		
		@NotNull(message = "employee code must not be null")
		@Min(value = 1, message = "employee code must not be empty")
		@Positive(message = "Employee Code must be a Positive value")
		private Long code;
		
		
		@NotBlank(message = "Employee name Cannot be null or empty")
		@Size(max = 100)
		private String name;
		
		@Size(max = 1, message = "Gender value must be M of F")
		private String gender;
		
		
		@NotBlank(message = "Employee jobTitle Cannot be null or empty")
		@Size(max = 100)
		private String jobTitle;
		
		
		@NotBlank(message = "Employee emailId Cannot be null or empty")
		@Email(message = "Employee mail id must be valid")
		@Size(max = 30)
		private String emailId;
		
		@Positive
		private Integer experience;
		
		
	
		@NotNull
		@Positive(message = "Employee phoneNumber must be a Positive value")
		private Long phoneNumber;
		
		@NotBlank
		private String location;
		
		
		@NotBlank(message = "Employee projectStatus Cannot be null or empty")
		@Size(max = 15, message = "project status cannot exceed size 15")
		private String projectStatus;
		
		public Long getCode() {
			return code;
		}
		public void setCode(Long code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Integer getExperience() {
			return experience;
		}
		public void setExperience(Integer experience) {
			this.experience = experience;
		}
		public Long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getProjectStatus() {
			return projectStatus;
		}
		public void setProjectStatus(String projectStatus) {
			this.projectStatus = projectStatus;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		public Employee prepareEmployeeEntity(EmployeeDTO empDto) {
			
			Employee emp = new Employee();
			emp.setCode(empDto.getCode());
			emp.setEmailId(empDto.getEmailId());
			emp.setExperience(empDto.getExperience());
			emp.setGender(empDto.getGender());
			emp.setJobTitle(empDto.getJobTitle());
			emp.setLocation(empDto.getLocation());
			emp.setName(empDto.getName());
			emp.setPhoneNumber(empDto.getPhoneNumber());
			emp.setProjectStatus(empDto.getProjectStatus());
			
			return emp;
		}
		
		public static EmployeeDTO valueOf(Employee emp) {
			
			EmployeeDTO empDto = new EmployeeDTO();
			empDto.setCode(emp.getCode());
			empDto.setEmailId(emp.getEmailId());
			empDto.setExperience(emp.getExperience());
			empDto.setGender(emp.getGender());
			empDto.setJobTitle(emp.getJobTitle());
			empDto.setLocation(emp.getLocation());
			empDto.setName(emp.getName());
			empDto.setPhoneNumber(emp.getPhoneNumber());
			empDto.setProjectStatus(emp.getProjectStatus());
			
			return empDto;
		}
}
