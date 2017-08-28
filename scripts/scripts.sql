drop table usuario;

create table usuario
(
    id integer primary key,
    username varchar(20) not null,
    password varchar(20) not null,
    ultimoacesso date not null
);