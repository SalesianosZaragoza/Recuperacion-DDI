create table IF NOT EXISTS OLDSTOREHOUSE(
	id bigint auto_increment,
    name varchar(25)
);

create table IF NOT EXISTS NEWSTOREHOUSE(
	id bigint auto_increment,
    name varchar(25)
);

create table IF NOT EXISTS BOOK(
	id bigint auto_increment,
	isbn varchar(25),
	editionDate date,
	oldStorehouse INT,
	newStorehouse INT,
	FOREIGN KEY (oldStorehouse  ) REFERENCES OLDSTOREHOUSE(id),
	FOREIGN KEY (newStorehouse  ) REFERENCES NEWSTOREHOUSE(id)
);
