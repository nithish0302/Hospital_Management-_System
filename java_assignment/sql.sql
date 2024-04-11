create database hospital;
use hospital;

create table patient (
patient_id int auto_increment primary key,
patient_name varchar(30),
gender varchar(10),
dob varchar(10),
address varchar(30),
phone_no int
);
select * from patient;

drop table  Appoitnment;
create table Appoitnment
(
appoinment_id int auto_increment primary key,
patient_id int,
staff_name varchar(20),
patient_name varchar(20),
appoinment_date_and_time varchar(20),
appoinment_status varchar(20)
);


create table Staff
(
staff_id int auto_increment primary key,
staff_name varchar(30),
gender varchar(10),
address varchar(20),
dob varchar(20),
phone_no int ,
department_no int ,
department_name varchar(20)
);

truncate table department;
create table department 
(
department_name varchar(20),
department_no int 
);


select * from patient;
