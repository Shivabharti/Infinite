SELECT * FROM Employ;

-- change value as 'Tanya Arora' for Empno 8

UPDATE Employ SET name='Tanya Arora' WHERE empno=8;

-- change values as name as 'Sriti' Gender 'Female' dept 'sap' desig 'manager' basic 999999 for
-- Empno=5

UPDATE Employ SET name= 'Smriti', Gender='FEMALE', Dept='SAP', Desig= 'Manager', Basic= 9999
WHERE empno= 5;

-- Change Name as 'Sonali Sahoo' Dept as 'Sql' desig as 'Expert' basic as 78999 for Empno 3

UPDATE Employ SET name= 'Sonali Sahoo', Dept='SQL', Desig='Expert', Basic= 78999
WHERE EMPNO= 3;

-- ADD 1000 TO BASIC FOR ALL SQL DEPT EMPLOYEES
UPDATE Employ SET BASIC=(BASIC+1000)
 WHERE Dept= 'Sql';
 
 UPDATE Employ SET basic= CASE Dept
	WHEN 'Sql' then basic+1000
    when 'Dotnet' then basic+700
    when 'Java' then basic+500
end;

SELECT EmpId FROM Employee WHERE ManagerId= 1001;

UPDATE Employee SET EmpName= UPPER(EmpName) WHERE EmpId in
(SELECT EmpId FROM leavedetails WHERE eMPid=1003);

SELECT * FROM Employee;

-- delete : used to delete table record(s)
-- Delete from table_name where condition

DELETE FROM Employ WHERE Empno=3; 