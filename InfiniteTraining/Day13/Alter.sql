use practice23;

drop table if exists empTest;

create Table EmpTest
(	
	Empno int,
    Name varchar(10),
    sal int
);

-- change the field name size to 30 chars

alter table EmpTest modify name varchar(30);
desc EmpTest;

-- Ad new field gender to the particular table

alter table EmpTest Add Gender ENUM('MALE','FEMALE');

-- add primary key on Empno field

alter table EmpTest add primary key(empno);
desc EmpTest;

