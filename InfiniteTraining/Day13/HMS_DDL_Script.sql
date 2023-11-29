DROP DATABASE IF EXISTS HMS;

CREATE DATABASE HMS;
USE HMS;

CREATE TABLE Doctor_master
(
	doctor_id VARCHAR(15) PRIMARY KEY NOT NULL,
    doctor_name VARCHAR(15) NOT NULL,
    Dept VARCHAR(15) NOT NULL
);

CREATE TABLE room_master
(
	room_no VARCHAR(15) NOT NULL,
    room_type VARCHAR(15) NOT NULL,
    status VARCHAR(15) NOT NULL,
    primary key(room_no)
);

CREATE TABLE patient_master
(
pid VARCHAR(15) NOT NULL,
name VARCHAR(15) NOT NULL,
age NUMERIC(15) NOT NULL,
Weight NUMERIC(15) NOT NULL,
Gender VARCHAR(10) NOT NULL,
Address VARCHAR(50) NOT NULL,
phoneno VARCHAR(10) NOT NULL,
Disease VARCHAR(50) NOT NULL,
Doctor_id VARCHAR(5),
primary key(pid),
foreign key(Doctor_id) references Doctor_master(Doctor_id)
);

CREATE TABLE Room_allocation
(
	
room_no Varchar(15),
pid Varchar(15), 
admission_date date NOT NULL,
Release_date date,
foreign key(room_no) references room_master(room_no),
foreign key(pid) references patient_master(pid)

);

USE HMS;
CREATE TABLE Patient_Report
(
	Report_Id int auto_increment primary key,
   Patient_Id VARCHAR(15),
   TestCode VARCHAR(15),
   TestName VARCHAR(50),
   TestDescription VARCHAR(100),
   Cost double,
   Comments VARCHAR(100),
   foreign key(Patient_Id) references patient_master(pid)

);


