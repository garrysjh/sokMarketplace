create database stringofkisses;
use stringofkisses;
create table product(
id int NOT NULL auto_increment primary key,
name varchar(50),
description text(100),
category_id int,
price float,
image varchar(255)
);
create table product_category(
id int NOT NULL auto_increment primary key,
name varchar(50),
description text(100)
);
create table user(
id int NOT NULL auto_increment primary key,
username varchar(50),
password varchar(50),
first_name char(50),
last_name char(50),
email varchar(100),
phone varchar(50),
isAdmin boolean
);
create table user_cart(
id int NOT NULL auto_increment primary key,
user_id int,
purchased boolean
);
create table cart_items(
id int NOT NULL auto_increment primary key,
product_id int,
quantity int,
cart_id int
);
insert into user VALUES(9, admin, admin, Admin, Admin, admin@gmail.com, 91234567, 1);
