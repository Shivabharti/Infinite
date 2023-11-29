

use infinite_august23;

drop table if exists Customer_Policy;
drop table if exists Ins_Plans;
drop table if exists insurance_Details;
drop table if exists Customer_Authorization;
drop table if exists Customer_Details;


create table insurance_Details
(
	Insurance_id varchar(10) primary key,
	Insurance_Name varchar(50),
	Type Varchar(30),
	PremiumStart int,
	PremiumEnd int,
	MinPeriod int,
	MaxPeriod int,
	LaunchDate Date,
	Status varchar(20)
);

create table Customer_Details
(
	Cust_ID varchar(10) primary key,
	FirstName varchar(30),
	LastName varchar(30),
	Gender varchar(5),
	DateOfBirth date,
	UserName varchar(30),
	PassCode varchar(100),
    Email varchar(50),
    ReTypePassCode varchar(100),
	Status varchar(10)
);

create table Customer_Authorization
(
Auth_ID int auto_increment primary key,
Cust_ID varchar(10),
Otp int(10),
Status varchar(10),
FOREIGN KEY (Cust_ID) REFERENCES Customer_Details(Cust_ID)

);

create table Customer_Policy
(
PolicyId int auto_increment primary key,
Cust_Id varchar(10),
Insurance_id varchar(10),
InsuranceAmount double,
PayMode enum("MONTHLY","QUARTERLY","HALFYEARLY","YEARLY"),
InitialAmount double,
RegisterDate date
);

create table Ins_Plans
(
	Plan_ID int primary key,
    Insurance_id varchar(50),
    PremiumAmount double,
    CoverageAmount double,
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id)
);

use infinite_august23;

INSERT INTO insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('INS001', 'LifeGuard Plus', 'Life Insurance', 5000, 10000, 5, 30, '2022-01-15', 'Active'),
    ('INS002', 'AutoShield', 'Auto Insurance', 300, 800, 1, 10, '2021-11-20', 'Active'),
    ('INS003', 'HealthMaster', 'Health Insurance', 2000, 5000, 3, 15, '2022-03-10', 'Active'),
    ('INS004', 'HomeGuard', 'Home Insurance', 800, 1500, 2, 20, '2022-05-05', 'Active'),
    ('INS005', 'TravelSafe', 'Travel Insurance', 250, 600, 1, 30, '2021-09-30', 'Active'),
    ('INS006', 'PetCare', 'Pet Insurance', 100, 300, 1, 10, '2022-02-14', 'Active'),
    ('INS007', 'SecureFuture', 'Life Insurance', 6000, 12000, 5, 30, '2021-12-01', 'Active'),
    ('INS008', 'CyberGuard', 'Cyber Insurance', 500, 1000, 1, 5, '2022-04-22', 'Active'),
    ('INS009', 'FarmShield', 'Agriculture Insurance', 1500, 4000, 3, 20, '2021-10-05', 'Active'),
    ('INS010', 'BusinessProtector', 'Business Insurance', 2000, 8000, 2, 15, '2022-03-28', 'Active'),
    ('INS011', 'CruiseGuard', 'Travel Insurance', 400, 1000, 1, 30, '2021-08-15', 'Active'),
    ('INS012', 'RetirementBliss', 'Retirement Insurance', 8000, 15000, 5, 30, '2022-02-10', 'Active'),
    ('INS013', 'EventShield', 'Event Insurance', 300, 800, 1, 10, '2021-11-10', 'Active'),
    ('INS014', 'PropertyGuard', 'Property Insurance', 1000, 2500, 2, 20, '2022-06-05', 'Active'),
    ('INS015', 'AdventureSafe', 'Travel Insurance', 200, 500, 1, 30, '2021-12-20', 'Active'),
    ('INS016', 'FamilyCare', 'Health Insurance', 1000, 3000, 3, 15, '2022-04-01', 'Active'),
    ('INS017', 'LegalShield', 'Legal Insurance', 300, 800, 1, 5, '2021-09-15', 'Active'),
    ('INS018', 'EducationGuard', 'Education Insurance', 500, 1500, 3, 20, '2022-01-05', 'Active'),
    ('INS019', 'TechSecure', 'Technology Insurance', 800, 2000, 2, 15, '2022-03-15', 'Active'),
    ('INS020', 'VacationGuard', 'Travel Insurance', 250, 600, 1, 30, '2021-10-10', 'Active');

use infinite_august23;
INSERT INTO Ins_Plans (Plan_ID, Insurance_id, PremiumAmount, CoverageAmount) VALUES
(1, 'INS001', 100.00, 50000.00),
(2, 'INS002', 75.50, 75000.00),
(3, 'INS001', 120.75, 60000.00),
(4, 'INS002', 85.25, 80000.00),
(5, 'INS001', 150.00, 55000.00),
(6, 'INS002', 90.75, 70000.00),
(7, 'INS003', 110.50, 90000.00),
(8, 'INS003', 70.25, 65000.00),
(9, 'INS003', 130.00, 72000.00),
(10, 'INS004', 95.75, 58000.00),
(11, 'INS004', 100.00, 50000.00),
(12, 'INS005', 75.50, 75000.00),
(13, 'INS005', 120.75, 60000.00),
(14, 'INS004', 85.25, 80000.00),
(15, 'INS005', 150.00, 55000.00),
(16, 'INS006', 90.75, 70000.00),
(17, 'INS007', 110.50, 90000.00),
(18, 'INS007', 70.25, 65000.00),
(19, 'INS008', 130.00, 72000.00),
(20, 'INS006', 95.75, 58000.00),
(21, 'INS001', 100.00, 50000.00),
(22, 'INS007', 75.50, 75000.00),
(23, 'INS001', 120.75, 60000.00),
(24, 'INS006', 85.25, 80000.00),
(25, 'INS001', 150.00, 55000.00),
(26, 'INS008', 90.75, 70000.00),
(27, 'INS008', 110.50, 90000.00),
(28, 'INS009', 70.25, 65000.00),
(29, 'INS009', 130.00, 72000.00),
(30, 'INS009', 95.75, 58000.00),
(31, 'INS010', 100.00, 50000.00),
(32, 'INS011', 75.50, 75000.00),
(33, 'INS010', 120.75, 60000.00),
(34, 'INS011', 85.25, 80000.00),
(35, 'INS012', 150.00, 55000.00),
(36, 'INS011', 90.75, 70000.00),
(37, 'INS012', 110.50, 90000.00),
(38, 'INS011', 70.25, 65000.00),
(39, 'INS013', 130.00, 72000.00),
(40, 'INS014', 95.75, 58000.00),
(41, 'INS014', 100.00, 50000.00),
(42, 'INS013', 75.50, 75000.00),
(43, 'INS013', 120.75, 60000.00),
(44, 'INS015', 85.25, 80000.00),
(45, 'INS015', 150.00, 55000.00),
(46, 'INS016', 90.75, 70000.00),
(47, 'INS017', 110.50, 90000.00),
(48, 'INS017', 70.25, 65000.00),
(49, 'INS018', 130.00, 72000.00),
(50, 'INS017', 95.75, 58000.00),
(51, 'INS016', 100.00, 50000.00),
(52, 'INS018', 75.50, 75000.00),
(53, 'INS019', 120.75, 60000.00),
(54, 'INS018', 85.25, 80000.00),
(55, 'INS016', 150.00, 55000.00),
(56, 'INS019', 90.75, 70000.00),
(57, 'INS020', 110.50, 90000.00),
(58, 'INS019', 70.25, 65000.00),
(59, 'INS020', 130.00, 72000.00),
(60, 'INS020', 95.75, 58000.00);

use infinite_august23;
alter table Customer_Policy add Plan_ID int;