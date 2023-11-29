use hms;
-- Query #1:Display the patients who were admitted in the month of january. 
select * from room_allocation
where month(admission_date)=1;

-- Query #2:Display the female patient who is not suffering from asthma 
select p.pid,p.name,p.gender, p.disease
FROM patient_master p WHERE P.GENDER='F'
AND P.disease <> 'Asthma';

-- Query #3:Count the number of male and female patients. 
select gender, count(*) as count from
patient_master group by gender;








