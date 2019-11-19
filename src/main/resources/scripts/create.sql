create table IF NOT EXISTS USER(
    id identity primary key,
	nombre varchar(25),
	apellido varchar(25)
    codEquipo integer,
    codEquipo references EQUIPO(id)
);
create table IF NOT EXISTS TEAM(
    id identity primary key,
    nombre varchar(25),
    
);