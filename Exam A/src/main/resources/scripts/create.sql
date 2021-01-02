create table IF NOT EXISTS ENTERPRISE(
	id bigint auto_increment,
    name varchar(25)
);

create table IF NOT EXISTS ALUMN(
	id bigint auto_increment,
	name varchar(25),
	age bigint,
	asistFCT boolean,
	enterprise INT,
	FOREIGN KEY (enterprise) REFERENCES ENTERPRISE(id)
);


ALTER TABLE ALUMN
    ADD FOREIGN KEY (enterprise) 
    REFERENCES ENTERPRISE(id)
