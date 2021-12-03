package com.hcl.usecase.ActivityService.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import com.hcl.usecase.ActivityService.dto.DailyActivityDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityRequestDTO;
import com.hcl.usecase.ActivityService.dto.DailyActivityResponseDTO;
import com.hcl.usecase.ActivityService.service.ActivityService;

public class ActivityHysterixService implements ActivityService {

	@Override
	public void addDailyActivity(DailyActivityRequestDTO activityRequestDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public DailyActivityResponseDTO viewDailyActivitywithname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editDailyActivity(DailyActivityRequestDTO activityRequestDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DailyActivityResponseDTO> viewDailyActivities(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyActivityResponseDTO> viewDailyActivity(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyActivityResponseDTO> viewDailyActivitieswithNameAndDateRange(DailyActivityDTO activityDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
