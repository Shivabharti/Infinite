DROP DATABASE IF EXISTS training_center;
CREATE DATABASE training_center;

USE training_center;

CREATE TABLE courses
(
	ccode VARCHAR(5) PRIMARY KEY,
    name VARCHAR(30),
    duration NUMERIC(3) UNSIGNED,
    fee NUMERIC(5) UNSIGNED,
    prerequisite VARCHAR(100)
);

CREATE TABLE faculty
(
	faccode VARCHAR(5) PRIMARY KEY,
    name VARCHAR(30),
    qual VARCHAR(30),
    exp VARCHAR(100) 
);

CREATE TABLE course_faculty
(
	faccode VARCHAR(5),
    ccode VARCHAR(5),
    grade CHAR(1) CHECK(grade IN ('A','B','C')),
    FOREIGN KEY (faccode) REFERENCES faculty(faccode),
    FOREIGN KEY (ccode) REFERENCES courses(ccode),
    PRIMARY KEY (faccode, ccode)
);

CREATE TABLE batches
(
	bcode VARCHAR(5) PRIMARY KEY,
    ccode VARCHAR(5) ,
    faccode VARCHAR(5),
    stDate DATE,
    endDate DATE,
    timing NUMERIC(1),
    FOREIGN KEY (ccode) REFERENCES courses(ccode),
    FOREIGN KEY (faccode) REFERENCES faculty(faccode),
    CHECK(stDate <= endDate),
    CHECK( timing IN (1,2,3))
);

CREATE TABLE students
(
	rollNo NUMERIC(5) PRIMARY KEY,
    bcode VARCHAR(5),
    name VARCHAR(30),
    gender CHAR(1) CHECK(gender IN ('M','F')),
    dj DATE,
    phone VARCHAR(10),
    email VARCHAR(30),
    FOREIGN KEY (bcode) REFERENCES batches(bcode)
);

CREATE TABLE payments
(
	rollNo numeric(5),
    dp DATE,
    amount NUMERIC(5),
    FOREIGN KEY (rollNo) REFERENCES students(rollNo)
);



-- MODULE 1
-- 1) Display records from students (Batch-wise total no.of students exists)
SELECT BCODE, COUNT(*) AS TotalStudents
FROM STUDENTS
GROUP BY BCODE;

-- 2) Display total payment paid by all students from payment table student-wise
SELECT ROLLNO, SUM(AMOUNT) AS TOTAL_PAYMENT
FROM PAYMENTS
GROUP BY ROLLNO;

-- 3) Display total no.of records from Payment table
SELECT COUNT(*) AS TotalRecords
FROM PAYMENTS;

 -- 4) Display total no.fo records from payment table, by eliminating duplicate student No
SELECT COUNT(DISTINCT ROLLNO) AS TotalUniqueStudents
FROM PAYMENTS;

-- 5) Display the ccode, max(stdate) from batches table.
SELECT CCODE, MAX(STDATE) AS MAX_START_DATE
FROM BATCHES
GROUP BY CCODE;

-- 6) Display max. fee from Course table.
SELECT CCODE, NAME, FEE
FROM COURSES
WHERE FEE = (
    SELECT MAX(FEE)
    FROM COURSES
);

-- 7) Display max. fee from Course table w.r.t. Ccode
SELECT CCODE, MAX(FEE) AS MaxFee
FROM COURSES
GROUP BY CCODE;

-- 8) Display total courses from batches table which are started in last 3 months
SELECT COUNT(*) AS TotalCourses
FROM BATCHES
WHERE STDATE >= DATE_SUB(NOW(), INTERVAL 3 MONTH);

-- 9) Display all courses from batches table w.r.t. Ccode (min 2 entries required)
SELECT DISTINCT B.CCODE, C.NAME AS Course_Name
FROM BATCHES B
INNER JOIN COURSES C ON B.CCODE = C.CCODE;

-- 10) Display all records from batches table, which courses are started last 3 months
-- and min. 2 records to be entered.
SELECT *
FROM BATCHES
WHERE STDATE >= DATE_SUB(NOW(), INTERVAL 3 MONTH);

-- 11) Display information from course_faculty table, as which faculty taking how many courses in ascending order w.r.t. Count
SELECT FACCODE, COUNT(CCODE) AS CourseCount
FROM COURSE_FACULTY
GROUP BY FACCODE
ORDER BY CourseCount ASC;

-- MODULE 2

-- 1) _HAVING_ clause is used to select groups based on condition.

--  YES,The HAVING clause in SQL is used to filter groups of rows based on a specified condition after using the GROUP BY clause.
-- It allows you to filter the result set to include only those groups that meet the specified condition.

-- 2) Select count(*) from students;  Is it a valid query.
-- YES	

-- 3) What is the order of WHERE, GROUP BY and ORDER BY.
-- WHERE (filtering) -> GROUP BY (grouping) -> HAVING (group-level filtering, if needed) -> ORDER BY (sorting).

-- 4) Display ROLLNO of students who have paid for more than twice.
SELECT ROLLNO
FROM PAYMENTS
GROUP BY ROLLNO
HAVING COUNT(*) > 2;

-- 5) Display average time taken for subject ORA.
SELECT
    C.CCODE,
    C.NAME AS Course_Name,
    C.DURATION AS Course_Duration,
    AVG(C.DURATION) AS Average_Duration
FROM
    COURSES C
WHERE
    C.CCODE = 'C001';

-- 6) Display faculty who can take more than 2 courses.
SELECT
    F.FACCODE,
    F.NAME AS Faculty_Name,
    COUNT(CF.CCODE) AS Course_Count
FROM
    FACULTY F
INNER JOIN
    COURSE_FACULTY CF ON F.FACCODE = CF.FACCODE
GROUP BY
    F.FACCODE, F.NAME
HAVING
    COUNT(CF.CCODE) > 2;

-- 7) Display least course fee.
SELECT *
FROM COURSES
WHERE FEE = (SELECT MIN(FEE) FROM COURSES);

-- 8) Display the number of months between first and last batches of course Java.
SELECT
    DATEDIFF(
		MAX(ENDDATE),
		MIN(STDATE)
    ) / 30 AS Months_Between
FROM
    BATCHES B
JOIN
    COURSES C ON B.CCODE = C.CCODE
WHERE
    C.NAME = 'Mathematics';
    
-- 9) Display Year, course and number of batches of that course.
SELECT
    YEAR(STDATE) AS Year,
    C.NAME AS Course,
    COUNT(*) AS Number_of_Batches
FROM
    BATCHES B
JOIN
    COURSES C ON B.CCODE = C.CCODE
GROUP BY
    YEAR(STDATE), C.NAME
ORDER BY
    Year, Course;

-- 11) Display the number of students joined in each month.
SELECT
    DATE_FORMAT(DJ, '%Y-%m') AS Month_Joined,
    COUNT(*) AS Number_of_Students_Joined
FROM
    STUDENTS
GROUP BY
    DATE_FORMAT(DJ, '%Y-%m')
ORDER BY
    Month_Joined;

-- 12) Display the number of students joined in each month  of the current year.
SELECT
    DATE_FORMAT(DJ, '%Y-%m') AS Month_Joined,
    COUNT(*) AS Number_of_Students_Joined
FROM
    STUDENTS
WHERE
    YEAR(DJ) = YEAR(CURDATE())
GROUP BY
    DATE_FORMAT(DJ, '%Y-%m')
ORDER BY
    Month_Joined;

-- MODULE 3
-- 1) Display all matching records from batches and Courses table.
SELECT
    B.*,
    C.NAME AS Course_Name
FROM
    BATCHES B
JOIN
    COURSES C ON B.CCODE = C.CCODE;
    
-- 2) Display matching/unmatching records from batches and courses table.
SELECT
    B.*,
    C.NAME AS Course_Name
FROM
    BATCHES B
LEFT JOIN
    COURSES C ON B.CCODE = C.CCODE;
    
-- 3) Display all matching records ascending order of stdate
SELECT
    B.*,
    C.NAME AS Course_Name
FROM
    BATCHES B
JOIN
    COURSES C ON B.CCODE = C.CCODE
ORDER BY
    B.STDATE ASC;

-- 4) Display all matching and unmatching records from batches, courses and faculty table.
SELECT
    B.*,
    C.NAME AS Course_Name,
    F.NAME AS Faculty_Name
FROM
    (BATCHES B
    LEFT JOIN
        COURSES C ON B.CCODE = C.CCODE)
RIGHT JOIN
    FACULTY F ON B.FACCODE = F.FACCODE;

-- MODULE 4
-- 1) What is required to join two tables?
-- To join two tables in SQL, you need a common column, a JOIN keyword (e.g., INNER JOIN or LEFT JOIN), and
-- an ON clause specifying the matching condition.

-- 2) What is meant by self-join?
-- A self-join in SQL refers to the act of joining a table to itself, typically using
-- related columns, to retrieve information about relationships or hierarchies within the same table.

-- 3) How do you qualify a column that is existing in two or more tables that are being joined?
-- To qualify a column that exists in two or more tables that are being joined, you should prefix the column name with the table alias or the table name to specify which table the column belongs to.
-- This is necessary to disambiguate the column and avoid ambiguity in your SQL query. Here's how you can do it:

-- 4) What is table alias? Is it stored anywhere?
--  table alias in SQL is a temporary name or shorthand used to represent a table within a SQL query. It allows you to simplify and clarify your SQL queries, especially when you are working with multiple tables, self-joins, or complex queries. Instead of typing out the full table name every time you
-- reference a column in a query, you can use the alias to make your query more concise and readable.

-- 5)What happens when you join two tables without any condition?
-- When you join two tables without any condition, it's like combining every item from the first table with every item from the second table. This can result in a lot of combinations, and the result might not make sense or be useful because there's no rule for how they should be matched. It's like mixing all the ingredients in your kitchen without following a recipe – you might get a mess instead of a delicious dish. To get meaningful results,
-- you usually need to specify how the items in the tables should be matched or related to each other using conditions or rules.


-- 6) Display rollno, student name, pay date and amount paid.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    P.DP AS Payment_Date,
    P.AMOUNT AS Amount_Paid
FROM
    STUDENTS S
JOIN
    PAYMENTS P ON S.ROLLNO = P.ROLLNO;

-- 7) Display rollno , student name, batch code ,  stdate of batch  and faculty code.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    B.BCODE AS Batch_Code,
    B.STDATE AS Batch_Start_Date,
    B.FACCODE AS Faculty_Code
FROM
    STUDENTS S
JOIN
    BATCHES B ON S.BCODE = B.BCODE;

-- 8) Display rollno , student name, course name  ,  stdate  of batch  and faculty code.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    C.NAME AS Course_Name,
    B.STDATE AS Batch_Start_Date,
    B.FACCODE AS Faculty_Code
FROM
    STUDENTS S
JOIN
    BATCHES B ON S.BCODE = B.BCODE
JOIN
    COURSES C ON B.CCODE = C.CCODE;

-- 9) Display rollno , student name, course name , faculty code and enddate of all batches that were completed.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    C.NAME AS Course_Name,
    B.FACCODE AS Faculty_Code,
    B.ENDDATE AS Batch_End_Date
FROM
    STUDENTS S
JOIN
    BATCHES B ON S.BCODE = B.BCODE
JOIN
    COURSES C ON B.CCODE = C.CCODE
WHERE
    B.ENDDATE IS NOT NULL;

	-- 10) Display students who have got more number of characters in name than the student with roll number 10.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name
FROM
    STUDENTS S
WHERE
    LENGTH(S.NAME) > (
	SELECT LENGTH(NAME)
        FROM STUDENTS
        WHERE ROLLNO = 10
    );

-- 11) Display rollno, student name, email , pay date and amount paid.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    S.EMAIL AS Email,
    P.DP AS Payment_Date,
    P.AMOUNT AS Amount_Paid
FROM
    STUDENTS S
JOIN
    PAYMENTS P ON S.ROLLNO = P.ROLLNO;

-- 12) In previous query include the details of student who haven’t paid anything so far.
SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    S.EMAIL AS Email,
    P.DP AS Payment_Date,
    P.AMOUNT AS Amount_Paid
FROM
    STUDENTS S
LEFT JOIN
    PAYMENTS P ON S.ROLLNO = P.ROLLNO;

-- 13) Display the details of students who have paid nothing so far.
    SELECT
    S.ROLLNO AS RollNo,
    S.NAME AS Student_Name,
    S.EMAIL AS Email
FROM
    STUDENTS S
LEFT JOIN
    PAYMENTS P ON S.ROLLNO = P.ROLLNO
WHERE
    P.ROLLNO IS NULL;

-- MODULE 5
-- 1) Get the details of students who have paid today.
SELECT S.ROLLNO, S.BCODE, S.NAME AS Student_Name, S.GENDER, S.DJ AS Date_of_Joining, S.PHONE, S.EMAIL
FROM STUDENTS S
INNER JOIN PAYMENTS P ON S.ROLLNO = P.ROLLNO
WHERE DATE(P.DP) = CURDATE();

-- 2) Display the details of batches handled by faculty name ‘Kevin Loney’.

 

-- 3) display the details of the faculty members who have not taken any batch in the last three months.

 

 -- 4) displays the details of batches that are taken by faculty with qualification MS or the course fee is more than 5000.

 

 
-- 5) displays the details of the students who belong to batches that are taken by faculty with qualification MS.

 

 -- 6) displays the details of the batches that have taken maximum duration among the batches of the same course.

 
-- 7) Get the details of course that has highest course fee.

 

-- 8) Get the details of students who have made a payment in the last month but no in the current month.

 

 

 

-- MODULE 6

-- 3) What is the result of x > ANY (10,20), if x is 15? ___1_____.

-- 4) Subquery always passes the result to the main-query [T/F] __TRUE___

-- 5) Subquery can be used in VALUES clause of INSERT command.[T/F] _TRUE___. 	

-- 6) Display details of courses taken by students who joined in the month of june, 2001.

-- 7) Delete the details of students who haven’t paid anything so far

-- 8) Display the details of course for which there are more than 3 batches.

-- 9) Display the details of course that has highest number of batches.

-- 10.	Change the ENDDATE of batch B8 to the ENDDATE of most recent batch.

-- 11) Display the details of students who haven’t paid total amount so far.

-- 12) Display the details of payment made by students of Oracle batch started on 5-dec-2000.










