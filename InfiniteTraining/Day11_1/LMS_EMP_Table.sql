USE infinite_august23;

DROP TABLE IF EXISTS LeaveDetails;

DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee(
	EmpId INT Primary key,
    EmpName VARCHAR(30),
    EmpEmail VARCHAR(30),
    MobileNo VARCHAR(30),
    DateOfJoin DATE,
    ManagerId INT,
    LeaveAvail INT
);

CREATE TABLE LeaveDetails
(
	LeaveId INT Primary Key AUTO_INCREMENT,
    EmpId INT,
    LeaveStartDate DATE,
    LeaveEndDate DATE,
    NoOfDays INT,
    LeaveType ENUM('EL','PL','ML'),
    LeaveStatus ENUM('PENDING','ACCEPTED','REJECTED') Default 'PENDING',
    LeaveReason VARCHAR(30),
    AppliedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Foreign Key(EmpId) REFERENCES Employee(EmpId)
);