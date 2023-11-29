use hms;
ALTER TABLE patient_master
ADD status varchar(10);
ALTER TABLE patient_master
ADD email varchar(30);
ALTER TABLE patient_master
ADD password varchar(10);
ALTER TABLE patient_master
ADD otp varchar(10);

