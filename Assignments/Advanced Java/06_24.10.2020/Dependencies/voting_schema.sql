create database voting_schema;
use voting_schema;

create table voters (id int primary key auto_increment,name varchar(20),
email varchar(20) unique,
password varchar(20),
status boolean,role varchar(20));
insert into voters values(default,'rama','rama@gmail.com','ram#123',0,'admin');
insert into voters values(default,'shekhar','shekhar@gmail.com','shk#123',0,'voter');

create table candidates(id int primary key auto_increment,
name varchar(20) unique,party varchar(20),votes int);
insert into candidates values(default,'ravi','bjp',0);
insert into candidates values(default,'asha','ncp',0);
insert into candidates values(default,'kiran','congress',0);
insert into candidates values(default,'riya','sp',0);
insert into candidates values(default,'subhash','aap',0);
