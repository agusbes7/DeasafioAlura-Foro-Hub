CREATE TABLE topicos(
    id bigint not null auto_increment,
   mensaje varchar(500) not null unique,
  fechaDeCreacion varchar(100) not null,
     estadoTopico varchar(100) not null unique,
rol varchar(100) not null,
    primary key(id)

);
