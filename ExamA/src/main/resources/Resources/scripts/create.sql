create table IF NOT EXISTS COMPANY(
	id bigint auto_increment,
    	name varchar(25)
);

create table IF NOT EXISTS STUDENT(
	id bigint auto_increment,
name_student varchar(25),
age bigint,
asistsFCT boolean,
company INT,
FOREIGN KEY (company ) REFERENCES COMPANY(id)
);
