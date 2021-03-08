create table IF NOT EXISTS ALMACEN_OLD(
	id bigint auto_increment,
    nombre varchar(25),
    PRIMARY KEY (id)
);

create table IF NOT EXISTS ALMACEN_NEW(
	id bigint auto_increment,
    nombre varchar(25),
    PRIMARY KEY (id)
);

create table IF NOT EXISTS LIBRO(
	id bigint auto_increment,
	isbn varchar(25),
	fechaEdicion date,
	almacen_old INT,
	almacen_new INT,
	PRIMARY KEY (id),
	FOREIGN KEY (almacen_old) REFERENCES ALMACEN_OLD(id),
	FOREIGN KEY (almacen_new) REFERENCES ALMACEN_NEW(id)
);