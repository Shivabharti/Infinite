USE HMS;
DELETE FROM doctor_master;
DELETE FROM patient_master;
DELETE FROM room_master;
DELETE FROM room;
INSERT INTO Doctor_master(doctor_id,doctor_name,dept)
VALUES('D0001','Ram','ENT'),
('D0002','Ranjan', 'ENT'),
('D0003','Smita','Eye'),
('D0004','Bhavan','Surgery'),
('D0005','Sheela','Surgery'),
('D0006','Nethra','Surgery');

INSERT INTO room_master(room_no, room_type, status)
VALUES('R0001','AC','occupied'),
('R0002','Suite', 'vacant'),
('R0003','NonAC','vacant'),
('R0004','NonAC','occupied'),
('R0005','AC','vacant'),
('R0006','AC','occupied');

INSERT INTO patient_master(pid, name,age,weight,gender,address,phoneno,disease,doctor_id)
VALUES('P0001','Gita', 35, 65, 'F', 'Chennai', '9867145678','Eye Infection','D0003'),
('P0002','Ashis', 40, 70, 'M', 'Delhi', '9845675678','Asthma','D0003'),
('P0003','Radha', 25, 60, 'F', 'Chennai', '9867166678','Pain in heart','D0005'),
('P0004','Chandra', 28, 55, 'F', 'Bangalore', '9978675567','Asthma','D0001'),
('P0005','Goyal', 42, 65, 'M', 'Delhi', '8967533223','Pain in Stomach ','D0004');

INSERT INTO Room_allocation(room_no,pid,admission_date,Release_date)
VALUES('R0001','P0001','2016-10-15','2016-10-26'),
('R0002','P0002','2016-11-15','2016-11-26'),
('R0002','P0003','2016-12-01','2016-12-30'),
('R0004','P0001','2017-01-01','2017-01-30');


