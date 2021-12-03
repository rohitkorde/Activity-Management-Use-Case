package com.hcl.usecase.ActivityService.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.usecase.ActivityService.entity.Activity;
import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;

@Component
public class DailyActivityResponseDTO {
	
	private Long code;
	private String name;
	private String jobTitle;
	private String emailId;
	private List<Activity> activities;
	
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
	
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public static DailyActivityResponseDTO getResponseDTO(EmployeeDTO emp, List<Activity> activity) {
		DailyActivityResponseDTO respDto = new DailyActivityResponseDTO();
		respDto.setCode(emp.getCode());
		respDto.setEmailId(emp.getEmailId());
		respDto.setJobTitle(emp.getJobTitle());
		respDto.setName(emp.getName());
		respDto.setActivities(activity);
		
		return respDto;
	}	
	

}
