USE infinite_august23;
INSERT INTO Student(Sno, Name, Sub1, Sub2, Sub3)
VALUES(1,'Ansal', 88,98,78),
(2,'Ariz', 86,67,99),
(3,'Sagar', 99,90,50),
(4,'Sriti', 76,56,65),
(5,'Jitendra', 77,66,45);

SELECT * FROM Student;
drop table if exists restaurantDemo;
Create table restaurantDemoagent
(
restId int primary key,
name varchar(50)
);

insert into restaurantDemo(restId, name)
values(1, "Sharma Restaurant"),
(2, "Veggy Paradise"),
(3, "Kheer Puri"),
(4, "Deshi Dhaba");

