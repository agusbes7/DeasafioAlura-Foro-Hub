CREATE TABLE usuarios(
    id bigint not null auto_increment,
   usuario varchar(100) not null unique,
  correo varchar(100) not null,
     clave varchar(100) not null unique,
rol varchar(100) not null,
    primary key(id)

);
