drop database if exists practice23;
create database practice23;
use practice23;
create table department
(
	deptNo int,
    Dname varchar(30),
    loc varchar(30),
    primary key(deptNo)

);


create table Employ
(
	Empno int,
    Deptno int,
    EmpName varchar(30),
    Gender enum('MALE','FEMALE'),
    city varchar(30),
    primary key(Empno),
    foreign key (DeptNo) references department(Deptno)
);

create table Project
(
	ProjCode int,
    Empno int,
    hours int,
    ProjName varchar(30),
    foreign key(Empno) References Employ (Empno),
    primary key(Empno, ProjCode)
    
);