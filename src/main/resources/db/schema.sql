drop table if exists posts;
drop table if exists users;
drop table if exists authorities;

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

CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

create table users
(
    id           serial primary key,
    username     varchar(255) not null unique,
    password     varchar(255) not null,
    enabled      boolean default true,
    authority_id int          not null references authorities (id)
);

insert into authorities (authority)
values ('ROLE_USER');
insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (username, password, enabled, authority_id)
VALUES ('n1', '$2a$10$r75N2dOijBEeusQ5ujUa9ODSda5jIZ5p/l1VeAjByPvNQnNdnwiUC',
        true, (select id from authorities where authority = 'ROLE_ADMIN'));