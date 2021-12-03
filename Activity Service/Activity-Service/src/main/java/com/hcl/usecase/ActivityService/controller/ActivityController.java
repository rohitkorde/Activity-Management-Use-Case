package com.hcl.usecase.ActivityService.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.ActivityService.dto.DailyActivityDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityRequestDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityResponseDTO;
import com.hcl.usecase.ActivityService.serviceImpl.ActivityServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Validated
public class ActivityController {
	
	@Autowired
	ActivityServiceImpl service;
	
	@PostMapping("/dailyactivity/add")
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeAdd")
	public ResponseEntity<String> addActivity(@Valid @RequestBody DailyActivityRequestDTO request) {
		service.addDailyActivity(request);
		return new ResponseEntity<String>("Activity Added Successfully", HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> handleEmployeeDownTimeAdd(@Valid @RequestBody DailyActivityRequestDTO request) {
		return new ResponseEntity<String>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeViewWithName")
	@GetMapping("/dailyactivity/{name}")
	public ResponseEntity<Object> viewDailyActivitywithname(@NotBlank(message = "Employee name must not be empty or null") @PathVariable String name) {
		DailyActivityResponseDTO dto =  service.viewDailyActivitywithname(name);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> handleEmployeeDownTimeViewWithName(@NotBlank(message = "Employee name must not be empty or null") @PathVariable String name) {
		
		return new ResponseEntity<Object>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PatchMapping("/dailyactivity/edit")
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeUpdate")
	public ResponseEntity<Object> updateActivity(@Valid @RequestBody DailyActivityRequestDTO requestDto) {
		service.editDailyActivity(requestDto);
		return new ResponseEntity<Object>("Employee Updated Successfully", HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Object> handleEmployeeDownTimeUpdate(@Valid @RequestBody DailyActivityRequestDTO requestDto){
		return new ResponseEntity<Object>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/dailyactivity/date/{date}")
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeByDate")
	public ResponseEntity<Object> getActivityByDate(@NotBlank(message = "Activity date must not be empty or null") @PathVariable String date){
		LocalDate localDate = LocalDate.parse(date);
		  
		List<DailyActivityResponseDTO> list =  service.viewDailyActivity(localDate);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> handleEmployeeDownTimeByDate(@NotBlank(message = "Activity date must not be empty or null") @PathVariable String date){
		return new ResponseEntity<Object>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/dailyactivity")
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeByCodeAndDateRange")
	public ResponseEntity<Object> viewActivityByCodeAndDateRange(@Valid @RequestBody DailyActivityDTO requestDto){
		
		List<DailyActivityResponseDTO> list =  service.viewDailyActivitieswithNameAndDateRange(requestDto);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> handleEmployeeDownTimeByCodeAndDateRange(@Valid @RequestBody DailyActivityDTO requestDto){
		return new ResponseEntity<Object>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/dailyactivity")
//	@HystrixCommand(fallbackMethod = "handleEmployeeDownTimeByDateBetween")
	public ResponseEntity<Object> viewActivityByDateBetween(@NotBlank(message = "Activity fromDate must not be empty or null") @RequestParam("fromDate") String fromDate, @NotBlank(message = "Activity toDate must not be empty or null") @RequestParam("toDate") String toDate){
		List<DailyActivityResponseDTO>  list =  service.viewDailyActivities(fromDate, toDate);
		
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> handleEmployeeDownTimeByDateBetween(@NotBlank(message = "Activity fromDate must not be empty or null") @RequestParam("fromDate") String fromDate, @NotBlank(message = "Activity toDate must not be empty or null") @RequestParam("toDate") String toDate) {
		return new ResponseEntity<Object>("We are facing Downtime for Employee Service, Apologies for inconvinience", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
