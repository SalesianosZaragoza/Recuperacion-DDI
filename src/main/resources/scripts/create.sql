CREATE TABLE IF NOT EXISTS RAZA(
	id identity primary key,
	especie varchar(30)
);

CREATE TABLE IF NOT EXISTS PERSONAJE(
	id identity primary key,
	nombre varchar(50),
	portador boolean,
	codRaza int NOT NULL,
	CONSTRAINT fk_raza foreign key (codRaza) references RAZA(id) ON DELETE CASCADE
);