package com.hcl.usecase.ActivityService.service;

import java.time.LocalDate;
import java.util.List;

import com.hcl.usecase.ActivityService.dto.DailyActivityDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityDateResponseDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityRequestDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityResponseDTO;

public interface ActivityService {
	
	public void addDailyActivity(DailyActivityRequestDTO activityRequestDTO);
	
	public DailyActivityResponseDTO viewDailyActivitywithname(String name);
	
	public void editDailyActivity(DailyActivityRequestDTO activityRequestDTO);
	
	public List<DailyActivityResponseDTO> viewDailyActivities(String fromDate, String toDate);
	
	public List<DailyActivityResponseDTO> viewDailyActivity(LocalDate date);
	
	public List<DailyActivityResponseDTO> viewDailyActivitieswithNameAndDateRange(DailyActivityDTO activityDto);

}
