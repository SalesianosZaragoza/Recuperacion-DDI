create table IF NOT EXISTS COMPANY(
	id bigint auto_increment,
    	name varchar(25)
);

create table IF NOT EXISTS STUDENT(
	id bigint auto_increment,
name_student varchar(25),
age bigint,
FCTasists boolean,
company INT,
FOREIGN KEY (comapny ) REFERENCES COMPANY(id)
);


ALTER TABLE STUDENT
    ADD FOREIGN KEY (company) 
    REFERENCES COMPANY(id)
