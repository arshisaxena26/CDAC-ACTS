--1. Create a table emp8 with columns employee_id, last_name, dept_id without any constraints. Use this table for next questions.

	CREATE TABLE IF NOT EXISTS emp8
	(
		employee_id INT UNSIGNED, 
    		last_name VARCHAR(10),  
    		department_id INT UNSIGNED
	);

--2. Add a new column salary with data type int to table emp8

	ALTER TABLE emp8
	ADD (salary INT UNSIGNED);

--3. Change data type of column salary to float.

	ALTER TABLE emp8
	MODIFY salary FLOAT;

--4. Remove column salary from table emp8.

	ALTER TABLE emp8
	DROP salary;

--5. Add not null constraint to column employee_id.

	ALTER TABLE emp8
	MODIFY employee_id INT UNSIGNED NOT NULL;

--6. You added not null constaint to employee_id by mistake. Now change it to primary key constraint.

	ALTER TABLE emp8
	MODIFY employee_id INT UNSIGNED,
	ADD PRIMARY KEY(employee_id);

--7. Add foreign key constraint to column dept_id which references to dept_id column in departments table.

	ALTER TABLE emp8
	ADD CONSTRAINT fk_deptartment_id FOREIGN KEY(department_id) REFERENCES departments(department_id);

--8. Add a new column phone which constraint unique. Now, rename it to contact.

	ALTER TABLE emp8
	ADD (phone VARCHAR(10) UNIQUE);

	ALTER TABLE emp8
	RENAME COLUMN phone TO contact;

--9. Drop primary key constraint from table emp8. Set a new composite primary key based on last_name and contact.

	ALTER TABLE emp8
	DROP PRIMARY KEY, ADD PRIMARY KEY(last_name,contact);

--10. Drop foreign key constraint on dept_id column from table emp8.
	
	ALTER TABLE emp8
	DROP FOREIGN KEY fk_deptartment_id;
	
--11. Rename table emp8 to emp9.

	ALTER TABLE emp8
	RENAME emp9;

--12. Delete table emp9 if it exists.

	DROP TABLE IF EXISTS emp9;

