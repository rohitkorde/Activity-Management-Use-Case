package com.hcl.usecase.EmployeeService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employee_code")
	private Long code;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name = "employee_gender")
	private String gender;
	
	@Column(name = "employee_designation")
	private String jobTitle;
	
	@Column(name = "employee_email_id")
	private String emailId;
	
	@Column(name = "employee_experience")
	private Integer experience;
	
	@Column(name = "employee_phone")
	private Long phoneNumber;
	
	@Column(name = "employee_location")
	private String location;
	
	@Column(name = "employee_status")
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	public EmployeeDTO prepareEmployeeDTO(Employee emp) {
		
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
