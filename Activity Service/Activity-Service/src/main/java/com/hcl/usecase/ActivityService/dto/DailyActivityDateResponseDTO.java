package com.hcl.usecase.ActivityService.dto;

import java.util.List;

public class DailyActivityDateResponseDTO {
	
	private String name;
	private String jobTitle;
	private String emailId;
	private List<DailyActivityRequestDTO> activities;
	
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
	public List<DailyActivityRequestDTO> getActivities() {
		return activities;
	}
	public void setActivities(List<DailyActivityRequestDTO> activities) {
		this.activities = activities;
	}
	
	

}
