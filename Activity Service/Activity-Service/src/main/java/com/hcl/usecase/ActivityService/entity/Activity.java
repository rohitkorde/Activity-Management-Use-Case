package com.hcl.usecase.ActivityService.entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcl.usecase.ActivityService.dto.DailyActivityRequestDTO;


@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue
	@Column(name = "activity_id")
	private Long activity_id;
	
	@Column(name = "employee_code")
	private Long employee_code;
	
	@Column(name = "activity_date")
	private LocalDate date;
	
	@Column(name = "activity_description")
	private String activity_description;
	
	@Column(name = "activity_status")
	private String activity_status;
	
	
	public Long getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Long activity_id) {
		this.activity_id = activity_id;
	}
	public Long getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(Long employee_code) {
		this.employee_code = employee_code;
	}

	public String getActivity_description() {
		return activity_description;
	}
	

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setActivity_description(String activity_description) {
		this.activity_description = activity_description;
	}
	public String getActivity_status() {
		return activity_status;
	}
	public void setActivity_status(String activity_status) {
		this.activity_status = activity_status;
	}
	
	public static Activity getActivity(Long Code, DailyActivityRequestDTO requestDto) {
		

		LocalDate date = LocalDate.now();
		Activity activity = new Activity();
		activity.setEmployee_code(Code);
		activity.setActivity_status(requestDto.getStatus());
		activity.setActivity_description(requestDto.getDescription());
		activity.setDate(date);
		
		return activity;
	}
	
}
