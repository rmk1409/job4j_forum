drop table if exists posts;
drop table if exists users;

create table posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

insert into posts (name, description)
values ('О чем этот форум?', 'description1');
insert into posts (name, description)
values ('Правила форума.', 'description2');

create table users
(
    id       serial primary key,
    name     varchar(255) unique,
    password varchar(255)
);

insert into users (name, password)
values ('n1', 'p1');
