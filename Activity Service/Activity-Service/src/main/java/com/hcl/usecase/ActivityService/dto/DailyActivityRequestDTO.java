package com.hcl.usecase.ActivityService.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class DailyActivityRequestDTO {
		
		@NotBlank(message = "employee name must null or empty")
		private String empName;
		
		@NotBlank(message = "description name must null or empty")
		private String description;
		
		@NotBlank(message = "status name must null or empty")
		private String status;
		
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
}
