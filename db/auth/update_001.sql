create table employee
(
    id        serial primary key,
    firstName varchar(2000),
    lastName  varchar(2000),
    inn       varchar(2000),
    created   timestamp
);
create table person
(
    id          serial primary key not null,
    login       varchar(2000),
    password    varchar(2000),
    employee_id int references employee (id)
);

insert into employee (firstName, lastName, inn, created) VALUES ('Ivan', 'Ivanov', '5609442', current_timestamp);
insert into employee (firstName, lastName, inn, created) VALUES ('Alexey', 'Goranov', '212111', current_timestamp);
insert into employee (firstName, lastName, inn, created) VALUES ('Kostya', 'Mashkov', '7537455', current_timestamp);

insert into person (login, password, employee_id)
values ('admin', '123', 1);
insert into person (login, password, employee_id)
values ('alex', '123', 2);
insert into person (login, password, employee_id)
values ('alexey', '123', 2);
insert into person (login, password, employee_id)
values ('Ivan', '123', 3);