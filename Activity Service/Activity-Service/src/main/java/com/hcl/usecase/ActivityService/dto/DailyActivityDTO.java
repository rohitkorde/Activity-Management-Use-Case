package com.hcl.usecase.ActivityService.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class DailyActivityDTO {
		
		@NotBlank(message = "Employee Name must not empty or null")
		private String name;
		
		@NotBlank(message = "from date must not be null or empty")
		private String fromDate;
		
		@NotBlank(message = "to date must not be null or empty")
		private String toDate;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		
		
		
}
