USE training_center;

-- Insert data into the COURSES table
INSERT INTO COURSES (CCODE, NAME, DURATION, FEE, PREREQUISITE) VALUES
('C01', 'DotNet Programming', 60, 9000, 'Basic programming knowledge'),
('C02', 'System Management', 30, 7000, 'None'),
('C03', 'FrontEnt Development', 60, 9000, 'HTML and CSS knowledge');

 

select * from courses;
-- Insert data into the FACULTY table
INSERT INTO FACULTY (FACCODE, NAME, QUAL, EXP) VALUES
('F01', 'Prof Ramesh Burnwal', 'M.Tech Development', '15+ years Experience'),
('F02', 'Dr. Ankit Yadav', 'Ph.D Software Development', '10+ years of teaching experience'),
('F03', 'Prof Shalini Saini', 'Ph.D. Web Development', '14+ years in web development');

 

select * from faculty;

 

-- Insert data into the COURSE_FACULTY table
INSERT INTO COURSE_FACULTY (FACCODE, CCODE, GRADE) VALUES
('F01', 'C01', 'A'),
('F02', 'C02', 'B'),
('F03', 'C03', 'A');

 

select * from course_faculty;

 

-- Insert data into the BATCHES table
INSERT INTO BATCHES (BCODE, CCODE, FACCODE, STDATE, ENDDATE, TIMING) VALUES
('B01', 'C01', 'F01', '2023-09-01', '2023-11-30', 1),
('B02', 'C02', 'F02', '2023-10-15', '2023-12-15', 2);

 

select * from batches;

 

-- Insert data into the STUDENTS table
INSERT INTO STUDENTS (ROLLNO, BCODE, NAME, GENDER, DJ, PHONE, EMAIL) VALUES
(101, 'B01', 'Rahulh Kumar', 'M', '2023-09-01', '9876543210', 'rahul@gmail.com'),
(102, 'B01', 'Niharika Singh', 'F', '2023-09-05', '9876543211', 'niharika@gmail.com'),
(103, 'B02', 'Altab hussain', 'M', '2023-10-15', '9876543220', 'altab@gmail.com');

 

select * from students;

 

-- Insert data into the PAYMENTS table
INSERT INTO PAYMENTS (ROLLNO, DP, AMOUNT) VALUES
(101, '2023-09-15', 2500),
(102, '2023-09-20', 3000),
(103, '2023-10-15', 4000);
select * from payments;