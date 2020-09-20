--Functions

--1. Write a program to take the input as empno and return the experience of employee in terms of number of years.
	
	DELIMITER #
	CREATE FUNCTION emp_experience
	(
	    p_empno INTEGER
	)	
	RETURNS INTEGER
	DETERMINISTIC
	BEGIN
		DECLARE emp_exp INTEGER;
	    	DECLARE hiredate DATE;
	    
	    	SELECT hire_date INTO hiredate FROM employees WHERE employee_id = p_empno;
	    	SET emp_exp = year(current_date())- year(hiredate);
	    
		RETURN (emp_exp);
	END#

--2. Write a program to take the input as deptno and return the comma separated list of employee names

	DELIMITER #
	CREATE FUNCTION emp_department
	(
	    p_deptno INTEGER
	)	
	RETURNS VARCHAR(500)
	DETERMINISTIC
	BEGIN
		DECLARE emp_names VARCHAR(500);
   		SELECT group_concat(first_name) INTO emp_names FROM employees WHERE department_id = p_deptno;
		RETURN (emp_names);
	END#

--3. Add a new column incentive to emp table. Write a program to calculate and update the incentive using following logic.
--     If employees salary is more then avg salary of dept then incentive is 0
--	 If employees salary is less then avg salary of dept then incentive is 10% of salary

	DELIMITER #
	CREATE FUNCTION getIncentives
	(
		p_empno INTEGER
	)
	RETURNS DECIMAL
	DETERMINISTIC
	BEGIN
		DECLARE incentive DECIMAL;
	    	DECLARE sal DECIMAL;
	    	DECLARE avg_sal DECIMAL;
	    	DECLARE dept INTEGER;
	    
	    	SELECT department_id INTO dept
	    	FROM employees
	    	WHERE employee_id = p_empno;
	    
	    	SELECT avg(salary) INTO avg_sal
	    	FROM employees
	    	GROUP BY department_id
	    	HAVING department_id = dept;
	    
	    	SELECT salary INTO sal
	    	FROM employees
	    	WHERE employee_id = p_empno;
	    
	    	IF sal < avg_sal THEN
			SET incentive = 0.1 * sal;
	    	ELSE 
			SET incentive = 0;
	    	END IF;    
	    
	    	RETURN (incentive);
	END#
	DELIMITER ;

	ALTER TABLE employees ADD (incentives DECIMAL);
	
	DELIMITER #
	CREATE PROCEDURE addIncentives()
	BEGIN
	    	DECLARE empno INTEGER;
		DECLARE incentive_value DECIMAL;
	   	 DECLARE emp_notfound BOOLEAN DEFAULT false;
	    
	    	DECLARE c_empRec CURSOR FOR SELECT employee_id FROM employees;
	    	DECLARE continue HANDLER FOR NOT FOUND SET emp_notfound=true;
	    
	    	OPEN c_empRec;
	    
	    	cur_loop : LOOP
			FETCH c_empRec INTO empno;
		     
			IF emp_notfound THEN
				LEAVE cur_loop;
			END IF;
		     
			SELECT getIncentives(empno) INTO incentive_value;
			UPDATE employees SET incentives = incentive_value WHERE employee_id = empno;
		
			END LOOP cur_loop;
		  
		CLOSE c_empRec;
	END#

	call addIncentives();
	
--4. Write a program to get the count of employees working in provided deptno.

	DELIMITER #
	CREATE FUNCTION empCount
	(
		p_deptno INTEGER
	)
	RETURNS INTEGER
	DETERMINISTIC
	BEGIN
		DECLARE emp_count INTEGER;
	    
	    	SELECT count(*) INTO emp_count 
	    	FROM employees 
	    	GROUP BY department_id
	   	HAVING department_id = p_deptno;
	    
	    	RETURN (emp_count);
	END#

