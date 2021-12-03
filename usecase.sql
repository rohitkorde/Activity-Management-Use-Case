-- use employeeservice;

-- Drop table if exists employee;

-- create table Employee (
-- 	employee_code bigint(10) primary key not null unique,
--     employee_name varchar(100) not null,
--     employee_gender char(1),
--     employee_designation varchar(100) not null,
--     employee_email_id varchar(100) not null,
--     employee_experience integer(2),
--     employee_phone bigint(10) not null,
--     employee_location varchar(100) not null,
--     employee_status varchar(15) not null
-- );

-- use activityservice;
-- DROP table if exists activity; 
-- create table Activity (
-- 	activity_id integer(10) primary key not null unique,
-- 	employee_code integer(10) not null,
--     activity_date date not null,
--     activity_description varchar(3000) not null,
--     activity_status varchar(10) not null
-- );
