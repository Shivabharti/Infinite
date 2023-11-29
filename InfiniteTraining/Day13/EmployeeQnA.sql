-- Display ManagerName for EmpId 1004

SELECT Mgr.EmpName AS ManagerName 
FROM Employee AS Emp
INNER JOIN Employee AS Mgr 
ON Emp.ManagerId=Mgr.EmpId
WHERE Emp.EmpId=1004;

-- Display EmployeeName(s) who are working as Abhishek(1001) manager
SELECT Emp.EmpName AS EmployeeName
FROM Employee AS Emp
INNER JOIN Employee AS Manager ON Emp.ManagerId= Manager.EmpId
Where Manager.EmpId=1001;


SELECT EmpId from Employee WHERE ManagerId= 1001;
SELECT EmpId from Employee WHERE ManagerId= 1001;





