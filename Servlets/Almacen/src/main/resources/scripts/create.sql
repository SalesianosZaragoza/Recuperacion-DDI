create table IF NOT EXISTS ALMACEN_OLD(
	id bigint auto_increment,
    name varchar(25)
);

create table IF NOT EXISTS ALMACEN_NEW(
	id bigint auto_increment,
    name varchar(25)
);

create table IF NOT EXISTS BOOK(
	id bigint auto_increment,
	isbn varchar(25),
	dateEdition date,
	almacen_old INT,
	almacen_new INT,
	FOREIGN KEY (almacen_old  ) REFERENCES ALMACEN_OLD(id),
	FOREIGN KEY (almacen_new  ) REFERENCES ALMACEN_NEW(id)
);