drop database if exists healthCare;
create database healthCare;
use healthCare;

create table admin_auth(
id int(10) primary key auto_increment,
name varchar(50),
username varchar(50),
email varchar(50),
password varchar(200)
);

create Table Adminreset_pwd
(
id int(10),
username varchar(50),
newPassword varchar(50),
confirmPassword varchar(50),
FOREIGN KEY (id) REFERENCES admin_auth(id)
);

CREATE TABLE Provider_Details(
providerid varchar(50) PRIMARY KEY, 
FirstName varchar(50) ,
LastName varchar(50),
DateOfBirth DATE,
email varchar(50),
LicenseNumber VARCHAR(20),
Qualification VARCHAR(100),
username varchar(50),
status varchar(50) default 'PENDING',
phoneno varchar(50),
gender ENUM ('MALE','FEMALE'),
speciality varchar(255),
address VARCHAR(255),
IsActive varchar(20),
comments varchar(255)
);
 

CREATE TABLE Provider_Authentication (
    Authid INT AUTO_INCREMENT PRIMARY KEY,
    providerid varchar(50) , 
    email varchar(50),
    username varchar(50),
    Password varchar(200),
    status varchar(50),
    otp varchar(20),
   FOREIGN KEY (providerid) REFERENCES Provider_Details(providerid)
);

CREATE TABLE Authentication (               
    Authid INT AUTO_INCREMENT PRIMARY KEY,
    UHID VARCHAR(50),
    username VARCHAR(50),
    Passcode VARCHAR(200),
    email VARCHAR(50),
    otp VARCHAR(20)
);

CREATE TABLE patient_enrollment (
    UHID varchar(50) PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DOB DATE,
    Gender ENUM('MALE', 'FEMALE','OTHER'),
    userName VARCHAR(50),
    Phone_no VARCHAR(50),
    email VARCHAR(200),
    status VARCHAR(50),
    cause VARCHAR(500),
    Address varchar(1000),
    medHistory Varchar(1000)
);

create table Patient_Appointment(
appointmentId varchar(20) primary key,
providerid varchar(50) , 
UHID varchar(50),
FirstName VARCHAR(50),
LastName VARCHAR(50),
AppointmentDate Date,
AppointmentTime varchar(50),
reason varchar(50),
Status enum('CONFIRMED','PENDING','CANCELED'),
FOREIGN KEY (providerid) REFERENCES Provider_Details(providerid),
FOREIGN KEY (UHID) REFERENCES patient_enrollment(UHID)
);

create table Doctor_Availability(
AvailabilityID varchar(10) primary key,
providerid varchar(10),
SlotDate DATE,
shift enum('MORNING','EVENING','ALL','NONE'),
IsAvailable int,
FOREIGN KEY (providerid) REFERENCES Provider_Details(providerid)
);

CREATE TABLE Insurance_Details (
    Insurance_id varchar(5) PRIMARY KEy,
    Insurance_Name VARCHAR(255),
    Type VARCHAR(255),
    PremiumStart DATE,
    PremiumEnd DATE,
    MinPeriod INT,
    MaxPeriod INT,
    LaunchDate DATE,
    Status VARCHAR(10)
);

CREATE TABLE Insurance_Plans (
    Plan_id INT AUTO_INCREMENT PRIMARY KEY,
    Insurance_id  varchar(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    Benefits varchar(369),
    Covered_Disease varchar(50),
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id)
    ); 

 
    

    
    CREATE TABLE Recipient_Insurance_History (
    S_no VARCHAR(10) PRIMARY KEY,
    Plan_id int,
    claimedDate Date,
    benefitPayout DOUBLE,
    benefitRemaining DOUBLE,
    FOREIGN KEY (Plan_id) REFERENCES Insurance_Plans(Plan_id)
);

  

CREATE TABLE Pharmacy_Authentication (
    Auth_id INT AUTO_INCREMENT PRIMARY KEY,
    pharm_id VARCHAR(50),
    email VARCHAR(50),
    Password VARCHAR(200),
    status VARCHAR(50),
    otp VARCHAR(20)
);

create table Prescription
( 
prescription_Id varchar(30) primary key,
providerid varchar(50) , 
foreign key (providerid) references Provider_Details(providerid),
UHID varchar(50),
foreign key(UHID) references patient_enrollment(UHID),
Symptoms varchar(20),
medicine varchar(20),
Dosage varchar(20),
Prescribed_Date  Timestamp default current_Timestamp ,
Instructions varchar(20)
);

CREATE TABLE Pharmacy (
    pharm_id VARCHAR(255) primary key,
    shop_name VARCHAR(255),
    address VARCHAR(255),
    lic_no VARCHAR(255),
    owner_name VARCHAR(255),
    regd_no VARCHAR(255),
    date_of_registration DATE,
    qualification VARCHAR(255),
    phone VARCHAR(15),
    email VARCHAR(255),
    regulatory VARCHAR(255)
);

CREATE TABLE Medicines (
    EntryId int PRIMARY KEY auto_increment,
    MedId VARCHAR(255),
    pharm_id VARCHAR(255),
    MedName VARCHAR(255) NOT NULL,
    Type VARCHAR(255),
    Quantity INT NOT NULL,
    EntryDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    MfgDate DATE NOT NULL,
    ExpiryDate DATE NOT NULL,
    Price DECIMAL(10, 2),
    FOREIGN KEY (pharm_id) REFERENCES Pharmacy(pharm_id)
);
 
 CREATE TABLE MedicineSales (
    SaleId VARCHAR(255) PRIMARY KEY,
    pharm_id VARCHAR(255),
    EntryId int,
    MedId VARCHAR(255),
    MedName VARCHAR(255),
    SaleDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2), 
    TotalPrice DECIMAL(10, 2),
    ProviderId Varchar(200),
    UHID Varchar(255),
    prescription_Id Varchar(255),
    FOREIGN KEY (pharm_id) REFERENCES Pharmacy(pharm_id),
    FOREIGN KEY (UHID) REFERENCES patient_enrollment(UHID),
    Foreign key (providerid) references Provider_Details(providerid),
    FOREIGN KEY (EntryId) REFERENCES Medicines(EntryId),
    FOREIGN KEY (prescription_Id) REFERENCES Prescription(prescription_Id)
);


CREATE TABLE Subscriptions (

    Subscription_Id INT AUTO_INCREMENT PRIMARY KEY,
	uhid varchar(50),
    foreign key(uhid)  references patient_enrollment(uhid),
    Plan_id INT,
	foreign key(plan_id) references Insurance_plans(plan_id),
    Insurance_id VARCHAR(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    PayMode VARCHAR(20),
    email varchar(30),
    RegistrationDate DATE,
    Initial_Amount DECIMAL(10, 2),
    Status VARCHAR(20)
);

create table insurance_Claim(
    Claim_Id int Auto_Increment Primary Key,
	providerid varchar(50), 
    Subscription_Id int,
    UHID varchar(100),
    foreign key(UHID) references patient_enrollment(UHID),
     foreign key(Subscription_Id) references Subscriptions(Subscription_Id),
     foreign key(providerid) references Provider_Details(providerid),
    Admit_date date,
    disc_date date,
    Bill_Amount numeric(11,2),
    Mis_Amount numeric(9,2),
    Disease varchar(100),
    Comments varchar(100)
    );
    
    	Create table claim_history(
   ClaimHistoryId int auto_increment primary key,
   Claim_Id int,
  providerid varchar(50), 
   Subscription_Id INT,
    UHID varchar(100),
    fromDate Date,
    toDate date,
    ReimbursementAmount decimal(9,2),
    PatientResponsibility decimal(9,2),
	foreign key(Claim_Id) references insurance_Claim(Claim_Id),
	foreign key(providerid) references Provider_Details(providerid),
     foreign key(Subscription_Id) references Subscriptions(Subscription_Id),
	foreign key(UHID) references patient_enrollment(UHID),
    status enum('ACCEPTED','REJECTED','PENDING') default 'PENDING',
    Comments varchar(20)
    );

