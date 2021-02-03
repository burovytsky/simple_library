create database library;

create table users(
id serial primary key not null,
name varchar(30)
)

create table book(
id serial primary key not null,
title varchar(30),
has_user boolean,
user_id int references users (id)
)

create table users_books
(
    user_id int ,
    book_id int ,
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
)

