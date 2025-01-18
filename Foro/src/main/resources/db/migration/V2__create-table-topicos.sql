CREATE TABLE topicos(
    id bigint not null auto_increment,
   mensaje varchar(500) not null unique,
   fechaDeCreacion varchar(100) not null,
   estadoTopico varchar(100) not null unique,
idUsuario bigint not null,
curso varchar(150) not null,
url varchar(359),

    primary key(id)

);
