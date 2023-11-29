use healthcare;


 INSERT INTO Insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('I001', 'Aditya Birla Activ Health Platinum Plan', 'Private', '2023-01-01', '2023-12-31', 1, 10, '2023-01-01', 'Active'),
    ('I002', 'Bharti AXA Smart Super Health Insurance Policy', 'Government', '2023-03-15', '2024-03-15', 1, 5, '2023-03-15', 'Active'),
    ('I003', 'Niva Bupa Heartbeat Health Insurance Plan', 'Private', '2023-02-01', '2033-02-01', 5, 30, '2023-02-01', 'Active'),
    ('I004', 'HDFC Ergo Health Suraksha', 'Private', '2023-04-01', '2024-04-01', 1, 10, '2023-04-01', 'Active'),
    ('I005', 'LIC Jeevan Arogya', 'Government', '2023-05-15', '2024-05-15', 1, 5, '2023-05-15', 'Active'),
    ('I006', 'Tata AIG Wellsurance Family', 'Private', '2023-06-01', '2033-06-01', 5, 30, '2023-06-01', 'Active'),
    ('I007', 'Reliance HealthGain', 'Private', '2023-07-01', '2024-07-01', 1, 10, '2023-07-01', 'Active'),
    ('I008', 'SBI General Arogya Premier Policy', 'Government', '2023-08-15', '2024-08-15', 1, 5, '2023-08-15', 'Active'),
    ('I009', 'ICICI Lombard Complete Health Insurance', 'Private', '2023-09-01', '2033-09-01', 5, 30, '2023-09-01', 'Active');
    
     INSERT INTO Insurance_Plans (Insurance_id, Premium_Amount, Coverage_Amount, Benefits, Covered_Disease)
VALUES
    ('I001', 100, 10000, 'Dental Care', 'Root canal treatment'),
    ('I001',989, 30000, 'Maternity Care','Normal delivery'),
	('I001', 300, 200000, 'Surgery','C-section Delivery'),
	('I001', 1000, 20000, 'diabetes','Cancer'),

     
	 ('I002', 1000.00, 100000.00, 'Hospitalization','Cataract'),
     ('I002', 200, 7500.00, 'Prescription Drugs','Covid-19'),
     ('I002', 800, 150000.00, 'Emergency Room','Cardivascular Dsease'),
     ('I002', 1200, 1500000.00, 'cardiac diseases','Novel Corona Virus'),
     
     
	('I003', 600, 20000.00, 'Mental Health Services','Pneumonia'),
    ('I003', 1200, 300000, 'Home Healthcare','Asthma'),
	('I003', 800, 20000, 'Chiropractic Care','Craving'),
	('I003', 900, 100000, 'Covid-19','Allergy')
;

use healthcare;

INSERT INTO Provider_Details (providerid, FirstName, LastName, DateOfBirth, email, LicenseNumber, Qualification, username, phoneno, gender, speciality, address, IsActive)
VALUES
    ('PROV001', 'Shyam', 'Rathore', '1985-07-15', 'shyamrathore@email.com', 'IN123456', 'MBBS', 'Shyam@123', '9876543210', 'MALE', 'General Physician', '123 Main Street, Mumbai', 'ACTIVE'),
    ('PROV002', 'Jane', 'Smith', '1990-04-25', 'jane.smith@email.com', 'IN789012', 'Dentist', 'janesmith', '8765432109', 'FEMALE', 'Dentistry', '456 Park Avenue, Delhi', 'ACTIVE'),
    ('PROV003', 'Rajesh', 'Kumar', '1980-11-30', 'rajesh.kumar@email.com', 'IN345678', 'Cardiologist', 'rajeshkumar', '7654321098', 'MALE', 'Cardiology', '789 Oak Lane, Bangalore', 'ACTIVE');