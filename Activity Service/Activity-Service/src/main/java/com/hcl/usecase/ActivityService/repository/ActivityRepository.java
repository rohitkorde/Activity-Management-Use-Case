package com.hcl.usecase.ActivityService.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.usecase.ActivityService.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	

	@Transactional
	@Query("Select a FROM Activity a WHERE a.employee_code = :empcode")
	List<Activity> findDistinctByEmployee_code(@Param("empcode") Long empcode);
	
	List<Activity> findByDate(LocalDate date);
	
	@Modifying
	@Transactional
	@Query("Update Activity a SET a.activity_description = :description, a.activity_status = :status, a.date = :date WHERE employee_code = :code AND activity_description = :description")
	void updateActivity(@Param("code") Long code, @Param("description")String description, @Param("status")String status, @Param("date")LocalDate date);
	
	@Transactional
	@Query("select a from Activity a where a.employee_code = :code and a.date >= :fromDate and a.date <= :toDate")
	List<Activity> findByCodeAndDateRange(@Param("code") Long code, @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
	
	@Transactional
	@Query("select a from Activity a where a.date between :fromDate and :toDate")
	List<Activity> findByDateBetween(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
