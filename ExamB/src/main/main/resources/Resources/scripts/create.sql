create table IF NOT EXISTS WAREHOUSE_OLD(
	id bigint auto_increment,
    	nameWO varchar(25)
);

create table IF NOT EXISTS WAREHOUSE_NEW(
	id bigint auto_increment,
    	nameWN varchar(25)
);

create table IF NOT EXISTS BOOK(
	id bigint auto_increment,
isbn varchar(25),
dateEdicion date,
warehouse_old INT,
warehouse_new INT,
FOREIGN KEY (warehouse_old  ) REFERENCES WAREHOUSE_OLD(id),
FOREIGN KEY (warehouse_new  ) REFERENCES WAREHOUSE_NEW(id)
);


