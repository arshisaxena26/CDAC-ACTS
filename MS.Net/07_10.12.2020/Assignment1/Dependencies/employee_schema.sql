CREATE DATABASE employee_schema;
USE employee_schema;

CREATE TABLE employee(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50),
	age int,
	salary int,
	PRIMARY KEY (id)
);

INSERT INTO employee VALUES(default,"Bob Johnson",25,56000);
INSERT INTO employee VALUES(default,"Rob Johnson",26,57000);
INSERT INTO employee VALUES(default,"Stacy Johnson",27,58000);
INSERT INTO employee VALUES(default,"Fiona Johnson",28,59000);
INSERT INTO employee VALUES(default,"Gracy Johnson",29,60000);