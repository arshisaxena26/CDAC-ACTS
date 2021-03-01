CREATE database employees;
use employees;

CREATE TABLE my_emp (
empid int(3) primary key auto_increment,
name varchar(20),
addr varchar(20),
salary double(8,2),
deptid varchar(10),join_date date);
INSERT INTO my_emp  VALUES(DEFAULT,'rama','pune',15000,'rnd','2015-11-18');
INSERT INTO my_emp  VALUES(DEFAULT,'shekhar','mumbai',18000,'rnd','2015-1-18');
INSERT INTO my_emp  VALUES(DEFAULT,'kiran','pune',13000,'prod','2016-7-8');
INSERT INTO my_emp  VALUES(DEFAULT,'riya','delhi',25000,'rnd','2015-3-18');
INSERT INTO my_emp  VALUES(DEFAULT,'meeta','chennai',21000,'prod','2017-11-18');
