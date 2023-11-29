DROP DATABASE IF EXISTS college;
CREATE DATABASE college;

USE college;

CREATE TABLE student
(
rollno INT PRIMARY KEY,
name VARCHAR(30),
marks INT NOT NULL,
grade VARCHAR(1),
city VARCHAR(20)
);

CREATE TABLE dept
(
	id INT PRIMARY KEY,
    subject VARCHAR(10)
);
CREATE TABLE teacher
(
	id INT PRIMARY KEY,
    name VARCHAR(30),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES dept(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO student
(rollno, name, marks, grade, city)
VALUES
(101, 'Anil', 99, 'A', 'Pune'),
(102,'Bhumika',87,'A', 'Mumbai'),
(103,'Shila', 67,'B','Delhi'),
(104,'Sweta', 90,'A', 'Punjab'),
(105, 'Seema',65, 'C', 'Delhi'),
(106, 'Amit', 56, 'B', 'Mumbai');

SELECT * FROM student;
SELECT marks FROM student;
SELECT DISTINCT city FROM student;
SELECT * FROM student WHERE marks>70;
SELECT * FROM student WHERE city= 'Delhi';
SELECT * FROM student WHERE grade='A';
SELECT * FROM student WHERE marks BETWEEN 80 AND 90;
SELECT * FROM student WHERE city NOT IN ('Delhi', 'Mumbai') LIMIT 1;
SELECT * FROM student LIMIT 2;
SELECT * FROM student ORDER BY marks DESC LIMIT 3;
SELECT MAX(marks) FROM student;
SELECT MIN(marks) FROM student;
SELECT AVG(marks) FROM student;
SELECT COUNT(rollNo) FROM student;
SELECT city,name, count(name) FROM student GROUP BY city,name;
SELECT city, AVG(marks) FROM student GROUP BY city ORDER BY AVG(marks) ASC;
SELECT grade, count(rollNo) FROM student GROUP BY grade;
SELECT city, COUNT(rollNo) FROM student GROUP BY city HAVING MAX(marks)> 90;

-- UPDATE Query

UPDATE student SET grade='O' WHERE grade= 'A';

SELECT * FROM student;

ALTER TABLE student
ADD COLUMN age INT NOT NULL DEFAULT 19;
 
 ALTER TABLE student 
 MODIFY COLUMN age VARCHAR(2) NOT NULL;
 
 ALTER TABLE student
 CHANGE age std_age INT;
 
 INSERT INTO student(rollno, name, marks, grade, city,std_age)
 VALUES(107, 'Nitish', 98, 'A','Kolkata', 100);
 
 ALTER TABLE student
 DROP COLUMN std_age;
 
 ALTER TABLE student 
 RENAME TO student_details;