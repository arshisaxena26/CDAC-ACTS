--1.Create a report to display the manager number and the salary of the lowest-paid employee for that manager. Exclude anyone whose manager is not known. Exclude any groups where the minimum salary is $6,000 or less. Sort the output in descending order of salary.

	SELECT manager_id, min(salary) MIN_SAL
	FROM employees e
	WHERE manager_id IS NOT NULL
	GROUP BY manager_id
	HAVING MIN_SAL > 6000
	ORDER BY MIN_SAL desc;

--2.Create a query to display the last name and salary for all employees. Format the salary to be 15 characters long, left-padded with the # symbol. Label the column as SALARY ?
	
	SELECT last_name, LPAD(salary,15,'#') AS 'SALARY'
	FROM employees;	

--======================================================
CREATE TABLE contacts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL, 
    email VARCHAR(255) NOT NULL
);

INSERT INTO contacts (first_name,last_name,email) 
VALUES ('Carine ','Schmitt','carine.schmitt@verizon.net'),
       ('Jean','King','jean.king@me.com'),
       ('Peter','Ferguson','peter.ferguson@google.com'),
       ('Janine ','Labrune','janine.labrune@aol.com'),
       ('Jonas ','Bergulfsen','jonas.bergulfsen@mac.com'),
       ('Janine ','Labrune','janine.labrune@aol.com'),
       ('Susan','Nelson','susan.nelson@comcast.net'),
       ('Zbyszek ','Piestrzeniewicz','zbyszek.piestrzeniewicz@att.net'),
       ('Roland','Keitel','roland.keitel@yahoo.com'),
       ('Julie','Murphy','julie.murphy@yahoo.com'),
       ('Kwai','Lee','kwai.lee@google.com'),
       ('Jean','King','jean.king@me.com'),
       ('Susan','Nelson','susan.nelson@comcast.net'),
       ('Roland','Keitel','roland.keitel@yahoo.com');
   
--Q1 : Delete duplicate rows using DELETE JOIN statement

	DELETE c2
	FROM contacts c1 JOIN contacts c2
	WHERE c1.email = c2.email AND c1.id < c2.id;

--Q2 : Delete duplicate rows using an intermediate table

	CREATE TEMPORARY TABLE contacts_copy AS
	SELECT c1.*
	FROM contacts c1 JOIN contacts c2
	WHERE c1.email = c2.email AND c1.id < c2.id;

	ALTER TABLE contacts_copy
	RENAME contacts;

--Q3 : Delete duplicate rows using the ROW_NUMBER() function

	DELETE FROM contacts
	WHERE id IN (SELECT id
			FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY email ORDER BY email) 'row_num'
				FROM contacts) AS temp
				WHERE row_num > 1);
	
