package com.hcl.usecase.EmployeeService.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.usecase.EmployeeService.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Employee e set e.name = :name, e.gender = :gender, e.jobTitle = :jobTitle, e.emailId = :emailId, e.experience = :experience, e.phoneNumber = :phoneNumber, e.location = :location,e.projectStatus = :projectStatus WHERE employee_code = :code")
	public void update(@Param("code") Long code, @Param("name") String name, @Param("gender") String gender, @Param("jobTitle") String jobTitle, @Param("emailId") String emailId, @Param("experience") Integer experience, @Param("phoneNumber") Long phoneNumber, @Param("location") String location, @Param("projectStatus") String projectStatus);
	
}
