create table IF NOT EXISTS ALMACEN_OLD(
	id bigint auto_increment,
    	nombre varchar(25)
);

create table IF NOT EXISTS ALMACEN_NEW(
	id bigint auto_increment,
    	nombre varchar(25)
);

create table IF NOT EXISTS LIBRO(
	id bigint auto_increment,
isbn varchar(25),
fechaEdicion date,
almacen_old INT,
almacen_new INT,
FOREIGN KEY (almacen_old  ) REFERENCES ALMACEN_OLD(id),
FOREIGN KEY (almacen_new  ) REFERENCES ALMACEN_NEW(id)
);





create table IF NOT EXISTS EMPRESA(
	id bigint auto_increment,
    	nombre varchar(25)
);

create table IF NOT EXISTS ALUMNO(
	id bigint auto_increment,
nombre varchar(25),
edad bigint,
asisteFCT boolean,
empresa INT,
FOREIGN KEY (empresa ) REFERENCES EMPRESA(id)
);


ALTER TABLE ALUMNO
    ADD FOREIGN KEY (empresa) 
    REFERENCES EMPRESA(id)

