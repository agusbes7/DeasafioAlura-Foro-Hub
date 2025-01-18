CREATE TABLE cursos(
    id bigint not null auto_increment,
  nombre varchar(100) not null unique,
  temas varchar(200) not null,
    primary key(id)

);
