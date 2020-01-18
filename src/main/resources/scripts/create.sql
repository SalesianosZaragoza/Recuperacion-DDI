CREATE TABLE IF NOT EXISTS race(
	id IDENTITY,
	specie VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS character(
	id IDENTITY,
	name VARCHAR(255),
	ringBearer VARCHAR(3),
	codRace INT,
	raceName varchar(50),
	CONSTRAINT fk_race foreign key (codRace) references race(id) ON DELETE CASCADE
); 