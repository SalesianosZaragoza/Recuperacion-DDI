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
