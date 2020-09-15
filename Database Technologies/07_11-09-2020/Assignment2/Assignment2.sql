--USE HR schema for following :-

--1. Create unique index on email in employees table.

	CREATE INDEX email_idx ON employees(email);

--2. create index on job_id and job_title in jobs table.

	CREATE INDEX job_info_idx ON jobs(job_id,job_title);

--3. create index on month values of hire_date column in employees table.
	
	CREATE INDEX month_idx ON employees((month(hire_date)));

--perform the following in sequence:

--1. set auto commit off
	
	SET autocommit=0;	

--2. insert one row in employees table.

	INSERT INTO employees VALUES (207,'Emma','Carstairs','EMMACARS','515.123.9999','1985-09-09','IT_PROG','12005.00',NULL,201,10);

--3. display the new inserted row.

	SELECT * FROM employees
	WHERE employee_id = 207;

--4. execute commit command.

	COMMIT;

--5. display the new inserted row.

	SELECT * FROM employees
	WHERE employee_id = 207;

--6. create a savepoint.

	SAVEPOINT insert_values;

--7. delete the new inserted row.

	DELETE FROM employees
	WHERE employee_id = 207;

--8. rollback to the previous created savepoint.

	ROLLBACK TO insert_values;	

