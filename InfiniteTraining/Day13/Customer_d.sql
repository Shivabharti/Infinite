DROP DATABASE IF EXISTS customer_d;
CREATE DATABASE customer_d;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
	Cust_ID INT Primary Key Auto_Increment,
	customer_Firstname varchar(30),
	customer_LastName varchar(30),
	customer_UserName varchar(30),
	customer_Password varchar(200),
	customer_Email  varchar(30),
	customer_PhoneNo varchar(15),
	Customer_Status varchar(20) DEFAULT 'OTP_PENDING',
	Customer_ActivatedOn DateTime
);

DROP TABLE IF EXISTS otp;
CREATE TABLE otp
(
	Otp_ID INT Primary Key Auto_Increment,
	Cust_ID INT,
	OptCode varchar(10),
	GeneratedOn DateTime,
    FOREIGN KEY(Cust_Id) REFERENCES customer(Cust_Id)
);

SELECT * FROM customer;









