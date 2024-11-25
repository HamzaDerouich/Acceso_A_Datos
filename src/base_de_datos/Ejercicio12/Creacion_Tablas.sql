drop database recetas;
create  database if no exists recetas;
use recetas;
create table recetas.origen
(
	id INT(11) primary key auto_increment not null,
	pais VARCHAR(50),
	region VARCHAR(50)
);

create table recetas.receta 
(
	id INT(11) primary key auto_increment not null,
	nombre VARCHAR(100) not null,
	tipo VARCHAR(50) not null,
	origen_id INT(11) not null,
	foreign key (origen_id) references  recetas.origen (id)
);

create table recetas.ingrediente
(
	id INT(11) primary key auto_increment not null,
	receta_id INT(11),
	nombre VARCHAR(50),
	cantidad VARCHAR(50),
	foreign key (receta_id) references recetas.receta (id)
);