use practice23;

delete from Department;
delete from Project;
Insert Into Department(Deptno, Dname, Loc)
values(101,'DotNet','Hyderabad'),
(102,'JAVA','Bangalore'),
(103, 'SQL', 'Chennai'),
(104, 'Testing','Delhi');

delete from Employ;
Insert Into Employ(Empno, DeptNo, EmpName, City, Gender)
Values(300,101,'Satya Prakash', 'Delhi', 'MALE'),
(301, 103,'Shivangi Bharti', 'Kolkata', 'FEMALE'),
(303, 101,'Ariz Khan', 'Bhubaneswar', 'MALE'),
(304, 103, 'Kishu Pallavi', 'Dhanbad', 'FEMALE'),
(305, 102, 'Akanksha Singh', 'Jamshedpur', 'FEMALE');

delete from Project;

insert into Project (ProjCode,Empno, hours,ProjName)
values(101,300,100,'ZC'),
(102,300,90,'City Bank'),
(101,303,190,'ZC');