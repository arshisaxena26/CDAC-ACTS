--DML:

--Create an employee table with colums employee_id, last_name,  hire_date, salary, department_id. Hire date column allows null values. Use appropriate dtypes and constraints.
	
	CREATE TABLE IF NOT EXISTS employee
	(
		employee_id INT UNSIGNED, 
    		last_name VARCHAR(10),  
		hire_date DATE DEFAULT NULL, 
    		salary DECIMAL, 
    		department_id INT UNSIGNED,
    		PRIMARY KEY (employee_id)
	);

--1. Insert follwing value to table: 100, King, 2010-01-01, 20000, 1

	INSERT INTO employee 
	VALUES (100,'King','2010-01-01',20000.00,1);

--2. Insert following value to table. Values are not in order: 2012-02-02, 101, Stark, 2, 10000

	INSERT INTO employee(hire_date,employee_id,last_name,department_id,salary) 
	VALUES ('2012-02-02', 101, 'Stark', 2, 10000.00);

--3. Insert following value to table. Hire date is not available: 102, Ernst, 15000,2

	INSERT INTO employee
	VALUES (102,'Ernst',NULL,15000.00,2);

--4. Insert multiple values to table in single query:
--	103, John, 2013-01-01, 10000, 1
--	104, Bond, 2013-04-01, 12000, 2
--	105, James, 2013-05-01, 18000, 1

	INSERT INTO employee
	VALUES (103,'John','2013-01-01',10000.00,1),
		(104,'Bond','2013-04-01',12000.00,2),
	        (105,'James','2013-05-01',18000.00,1);

--5. Date format of input data is different. Insert this value to table.
--	106, Austin, 31-07-19, 20000, 2

	INSERT INTO employee()
	VALUES (106,'Austin',str_to_date('31-07-19', '%d-%m-%Y'),20000.00,2);

--6. Change department id of employee with id 105 to 3.

	UPDATE employee
	SET department_id = 3
	WHERE employee_id = 105;

--7. For employee with id 106, update dpeartment id to 3 and hire date to 2015-07-31
	
	UPDATE employee
	SET department_id = 3, hire_date = '2015-07-31'
	WHERE employee_id = 106;

--8. Increment salary of employees working in department 1 by 10%

	SET SQL_SAFE_UPDATES = 0; --To Avoid Error Code: 1175.	
	
	UPDATE employee
	SET salary = salary + 0.1 * salary
	WHERE department_id = 1;

--9. Delete records from table having department_id = 3

	DELETE FROM employee
	WHERE department_id = 3;

--10. Check working of commit and rollback. Insert or delete records from table if required.

	SAVEPOINT all_records;

	DELETE FROM employee
	WHERE department_id = 2;
	
	ROLLBACK TO all_records; -- UNDO DELETE COMMAND

	INSERT INTO employee()
	VALUES (105,'James','2013-05-01',18000.00,3);

	COMMIT;

