create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);
create table prestamo (
 id int(11) not null auto_increment,
 tipo varchar(100) not null,
 nombre varchar(100) not null,
 valor_prestamo double(100) not null,
 fecha_prestamo datetime null,
 idUsuario varchar(45) not null,
 primary key (id)
);