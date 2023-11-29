CREATE DATABASE infinite_august23;

USE infinite_august23;

CREATE TABLE Employ(
	Empno INT PRIMARY KEY,
    Name VARCHAR(30),
    Gender ENUM('MALE', 'FEMALE'),
    Dept VARCHAR(30),
    Desig VARCHAR(30),
    Basic NUMERIC(9,2)
);

