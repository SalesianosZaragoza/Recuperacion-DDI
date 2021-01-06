create table IF NOT EXISTS USER(
	name varchar(25) PRIMARY KEY,
	course bigint,
	dateOfBirth date
);

create table IF NOT EXISTS CLASSROOM(
	id bigint auto_increment,
	name varchar(25)
);

 ALTER TABLE USER
    ADD FOREIGN KEY (course) 
    REFERENCES CLASSROOM(id)