package com.hcl.usecase.ActivityService.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.usecase.ActivityService.dto.DailyActivityDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityDateResponseDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityRequestDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityResponseDTO;
import com.hcl.usecase.ActivityService.entity.Activity;
import com.hcl.usecase.ActivityService.exception.NoActivitiesFound;
import com.hcl.usecase.ActivityService.feign.EmployeeFeignClient;
import com.hcl.usecase.ActivityService.repository.ActivityRepository;
import com.hcl.usecase.ActivityService.service.ActivityService;
import com.hcl.usecase.EmployeeService.dao.EmployeeDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	EmployeeFeignClient feignClient;
	
	
	@Override
	public void addDailyActivity(DailyActivityRequestDTO activityRequestDTO) {
		
		List<EmployeeDTO> list = feignClient.viewAllEmployees();
		List<EmployeeDTO> employee = list.stream().filter(x -> x.getName().equals(activityRequestDTO.getEmpName())).collect(Collectors.toList());
		if(employee.isEmpty()) {
			throw new NoActivitiesFound("102", "No Employee Found in database");
		}
		Long code = employee.get(0).getCode();
		activityRepository.save(Activity.getActivity(code, activityRequestDTO));
		
	}
	
	

	@Override
	public DailyActivityResponseDTO viewDailyActivitywithname(String name) {
		
		List<EmployeeDTO> list = feignClient.viewAllEmployees();
		List<EmployeeDTO> employee = list.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
		if(employee.isEmpty()) {
			throw new NoActivitiesFound("102", "No Employee Found in database");
		}
//		Activity activity = activityRepository.findByEmployeeCode(employee.get(0).getCode());
		List<Activity> activity = activityRepository.findDistinctByEmployee_code(employee.get(0).getCode());
		if(activity.isEmpty()) {
			throw new NoActivitiesFound("103", "No Activity Found for Employee in database");
		}
		return DailyActivityResponseDTO.getResponseDTO(employee.get(0), activity);
		
	}

	@Override
	public void editDailyActivity(DailyActivityRequestDTO activityRequestDTO) {
		
		LocalDate date = LocalDate.now();
		List<EmployeeDTO> list = feignClient.viewAllEmployees();
		List<EmployeeDTO> employee = list.stream().filter(x -> x.getName().equals(activityRequestDTO.getEmpName())).collect(Collectors.toList());
		Long code = employee.get(0).getCode();
		activityRepository.updateActivity(code, activityRequestDTO.getDescription(), activityRequestDTO.getStatus(),date);

	}

	@Override
	public List<DailyActivityResponseDTO> viewDailyActivities(String fDate, String tDate) {
		LocalDate fromdate = LocalDate.parse(fDate);
		LocalDate toDate = LocalDate.parse(tDate);
		
		List<Activity> activities = activityRepository.findByDateBetween(fromdate, toDate);
		
		List<DailyActivityResponseDTO> responseList = new ArrayList<DailyActivityResponseDTO>();
		for(Activity e: activities) {
			List<Activity> list = new ArrayList<Activity>();
			list.add(e);
			EmployeeDTO empDto = feignClient.viewEmployeeByCode(e.getEmployee_code());
			DailyActivityResponseDTO dto = new DailyActivityResponseDTO();
			dto.setActivities(list);
			dto.setCode(empDto.getCode());
			dto.setEmailId(empDto.getEmailId());
			dto.setJobTitle(empDto.getJobTitle());
			dto.setName(empDto.getName());
			responseList.add(dto);
		}
		
		if(responseList.isEmpty()) {
			throw new NoActivitiesFound("101", "No Activities Found");
		}
		return responseList;
	}

	@Override
	public List<DailyActivityResponseDTO> viewDailyActivity(LocalDate date) {
		
		List<Activity> activities = activityRepository.findByDate(date);
		List<DailyActivityResponseDTO> responseList = new ArrayList<DailyActivityResponseDTO>();
		for(Activity e: activities) {
			List<Activity> list = new ArrayList<Activity>();
			list.add(e);
			EmployeeDTO empDto = feignClient.viewEmployeeByCode(e.getEmployee_code());
			DailyActivityResponseDTO dto = new DailyActivityResponseDTO();
			dto.setActivities(list);
			dto.setCode(empDto.getCode());
			dto.setEmailId(empDto.getEmailId());
			dto.setJobTitle(empDto.getJobTitle());
			dto.setName(empDto.getName());
			responseList.add(dto);
		}
		
		if(responseList.isEmpty()) {
			throw new NoActivitiesFound("101", "No Activities Found");
		}
		return responseList;
	}
	
	@Override
	public List<DailyActivityResponseDTO> viewDailyActivitieswithNameAndDateRange(DailyActivityDTO activityDto) {
		List<EmployeeDTO> list = feignClient.viewAllEmployees();
		
		List<EmployeeDTO> employee = list.stream().filter(x -> x.getName().equals(activityDto.getName())).collect(Collectors.toList());
		
		Long code = employee.get(0).getCode();
		
		LocalDate fromDate = LocalDate.parse(activityDto.getFromDate());
		LocalDate toDate  = LocalDate.parse(activityDto.getToDate());
		
		List<DailyActivityResponseDTO> responseList = new ArrayList<DailyActivityResponseDTO>();
		
		List<Activity> activities = activityRepository.findByCodeAndDateRange(code,fromDate, toDate);
		
		for(Activity e: activities) {
			
			List<Activity> list1 = new ArrayList<Activity>();
			list1.add(e);
			EmployeeDTO empDto = feignClient.viewEmployeeByCode(e.getEmployee_code());
			DailyActivityResponseDTO dto = new DailyActivityResponseDTO();
			dto.setActivities(list1);
			dto.setCode(empDto.getCode());
			dto.setEmailId(empDto.getEmailId());
			dto.setJobTitle(empDto.getJobTitle());
			dto.setName(empDto.getName());
			responseList.add(dto);
			
		}
		if(responseList.isEmpty()) {
			throw new NoActivitiesFound("101", "No Activities Found");
		}
		return responseList;
		
	}

}
