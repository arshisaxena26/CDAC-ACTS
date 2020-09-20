--Procedure
--==========
--1. Prepare a program which can perform following operation
--	- Lookout for tables which has missing constraints
--	- Display list of those tables
	
	DELIMITER #
	CREATE PROCEDURE missingConstraints()
	BEGIN
		SELECT table_name
		FROM information_schema.tables
		WHERE table_schema = 'humanresource'
		AND table_name NOT IN (SELECT DISTINCT table_name
					FROM information_schema.table_constraints
					WHERE table_schema = 'humanresource');
	END#

--2. Prepare a program to delete the data from emp. It will receive two inputs employee number and employee name. If employee number is passed --as null then delete the data based on employee name.
--Backup the deleted data to employee_backup table.

	CREATE TABLE employee_backup LIKE employees;

	DELIMITER #
	CREATE PROCEDURE deleteEmpData
	(
		p_empno INTEGER,
	    	p_empname VARCHAR(30)
	)
	BEGIN
		IF empno IS NULL THEN
			INSERT INTO employee_backup 
			SELECT * FROM employees WHERE first_name = p_empname;

			DELETE FROM employees WHERE first_name = p_empname;
	    	ELSE
			INSERT INTO employee_backup 
			SELECT * FROM employees WHERE employee_id = p_empno;

			DELETE FROM employees WHERE employee_id = p_empno;
	   	END IF;    
	END#

	

--3. Prepare a program to insert new record in employee table. it will take the input of employee data.
--If salary is provided as null then consider the salary as highest salary earned by any employee in same department. If comm is not provided --then assume it as 200$

	DELIMITER #
	CREATE PROCEDURE insertEmpData
	(
	    p_empno INTEGER,
	    p_fname VARCHAR(20),
	    p_lname VARCHAR(25),
	    p_email VARCHAR(25),
	    p_phno VARCHAR(20),
	    p_jobid VARCHAR(10),
	    p_sal DECIMAL(8,2),
	    p_comm DECIMAL(2,2),
	    p_managerid INTEGER,
	    p_deptid INTEGER
	)
	BEGIN
		IF p_sal IS NULL THEN
			SELECT max(salary) INTO p_sal FROM employees WHERE department_id = p_deptid;
	    	END IF;
	    
	    	IF p_comm IS NULL THEN
			SET p_comm = 200;
	    	END IF;
	    
	    	INSERT INTO employees
	    	VALUES (p_empno,p_fname,p_lname,p_email,p_phno,p_jobid,p_sal,p_comm,p_managerid,p_deptid);
	END#
	

--4. Prepare a program to receive the input as table name and column name. Add primary key constraint on provided table's column.

	DELIMITER #
	CREATE PROCEDURE addConstraint
	(
	    p_tableName VARCHAR(20),
	    p_columnName VARCHAR(20)
	)
	BEGIN
	    SET @alter_query = CONCAT('ALTER TABLE ',p_tableName,' DROP primary key, ADD primary key(',p_columnName,')');
	    
	    PREPARE statement FROM @alter_query; 
	    EXECUTE statement;
	    DEALLOCATE PREPARE statement; 
	END#

--5. Prepare a program to list those employee who are earning less then avg of their deparment. This program may take input as (p_salary_fix BOOLEAN). If the input is given as true then these employees salary must be set to AVG Salary + 100$.


	CREATE OR REPLACE VIEW updatedSalary_view
	AS 
	SELECT first_name, salary, avg_sal
	FROM employees e JOIN (SELECT department_id,avg(salary) avg_sal FROM employees GROUP BY department_id) AS temp
	ON e.department_id = temp.department_id
	WHERE e.salary < avg_sal;
	
	
	DELIMITER #
	CREATE PROCEDURE setSalary
	(
		p_salary_fix BOOLEAN
	)
	BEGIN
		DECLARE ename VARCHAR(50);
	    	DECLARE sal,avg_salary DECIMAL;
		DECLARE v_notfound BOOLEAN DEFAULT false;
	 
		DECLARE c_emp CURSOR FOR SELECT * FROM updatedSalary_view;
	    	DECLARE continue HANDLER FOR NOT FOUND SET v_notfound=true;
	    
	    	IF p_salary_fix THEN
			OPEN c_emp;
		  
			cur_loop : LOOP
				FETCH c_emp INTO ename,sal,avg_salary;
		     
				IF v_notfound THEN
					LEAVE cur_loop;
				END IF;
		     
			UPDATE updatedSalary_view SET salary = avg_salary + 100 WHERE first_name = ename;
					
			END LOOP cur_loop;
		  
			CLOSE c_emp;
 			SELECT 'Salaries Updated!';
            
            	ELSE 
			SELECT * FROM updatedSalary_view;
	    	END IF;    
	END#

