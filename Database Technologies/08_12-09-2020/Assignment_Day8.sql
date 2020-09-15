--Q1. Create a view to fetch the employees data 
--EmployeeId, EmployeeName, EmployeeSalary, EmployeeManager, EmployeeDepartment

	CREATE OR REPLACE VIEW emp_information
	AS
	SELECT e.employee_id EmployeeId, concat(e.first_name,' ',e.last_name) EmployeeName, 
		e.salary EmployeeSalary, concat(m.first_name,' ',m.last_name) EmployeeManager, d.department_name EmployeeDepartment
	FROM employees e JOIN employees m ON e.manager_id = m.employee_id
	JOIN departments d ON d.department_id = e.department_id;

--Q2. Create a view to fetch all the employees data working on jobs with 
--minimum salary > 2000 and maximum salary < 5000;

	CREATE OR REPLACE VIEW emp_salary_range
	AS
	SELECT * FROM employees
    	WHERE salary BETWEEN 2001 AND 4999;

--Q3. Create a view to fetch employee data 
--EMPLOYEEID,EMPLOYEENAME,EMPLOYEEDEPARTMENT,EMPLOYEESALARY,EMPLOYEECOUNTRY,EMPLOYEELOCATION,
--EMPLOYEEREGION.

	CREATE OR REPLACE VIEW employee_details_view
	AS
	SELECT e.employee_id EMPLOYEEID, 
		concat(e.first_name,' ',e.last_name) EMPLOYEENAME, 
        	d.department_name EMPLOYEEDEPARTMENT,
		e.salary EMPLOYEESALARY, 
       	 	c.country_name EMPLOYEECOUNTRY, 
        	l.city EMPLOYEELOCATION, 
        	r.region_name EMPLOYEEREGION
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON l.location_id = d.location_id
	JOIN countries c ON c.country_id = l.country_id
	JOIN regions r ON r.region_id = c.region_id;    

--Q4. CREATE A VIEW FOR Q3 AND DISPLAY ONLY THOSE EMPLOYEES WHOSE DEPARTMENTID = 30 AND SALARY < 5000;
	
	CREATE OR REPLACE VIEW employee_dept30lowSal_view
	AS
	SELECT e.employee_id EMPLOYEEID, 
		concat(e.first_name,' ',e.last_name) EMPLOYEENAME, 
        	d.department_name EMPLOYEEDEPARTMENT,
		e.salary EMPLOYEESALARY, 
       	 	c.country_name EMPLOYEECOUNTRY, 
        	l.city EMPLOYEELOCATION, 
        	r.region_name EMPLOYEEREGION
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON l.location_id = d.location_id
	JOIN countries c ON c.country_id = l.country_id
	JOIN regions r ON r.region_id = c.region_id
    	WHERE e.department_id = 30 AND e.salary < 5000;   

--Q5. CREATE A VIEW TO FETCH ALL EMPLOYEES DATA WITH THERE APPRAISED SALARY FOR THE CURRENT YEAR.

--EG : CURRENT SALARY = 3000
--COMM : 300
--APPRAISED SALARY RULE : 
--		PEOPLE GETTING SALARY 2000 - 10000 :: 10%
--		PEOPLE GETTING SALARY 10001 -15000 :: 8%
--		PEOPLE GETTING SALARY 15000 - 20000 :: 6%
--		PEOPLE GETTING SALARY > 20000 :: 5%
	
	CREATE OR REPLACE VIEW employee_AppraisedSalary
	AS
	SELECT *, CASE
			WHEN salary BETWEEN 2000 AND 10000 THEN salary * 1.10
			WHEN salary BETWEEN 10001 AND 15000 THEN salary * 1.08
			WHEN salary BETWEEN 15001 AND 20000 THEN salary * 1.06
			WHEN salary > 20001 THEN salary * 1.05
			END AS AppraisedSalary
	FROM employees;		
		
--Q6. CREATE A VIEW ON THE EMPLOYEES TABLE WITH EMPNO , EMPNAME, EMPSALARY
	
	CREATE OR REPLACE VIEW emp_details
	AS
	SELECT employee_id EMPNO, concat(first_name,' ',last_name) EMPNAME, salary EMPSALARY
	FROM employees;

--	1. UPDATE THE SALARY OF EMPLOYEE ID = 105;

	UPDATE emp_details 
	SET EMPSALARY= 6000
	WHERE EMPNO = 105;

--	2. DELETE THE ROW OF THE EMPLOYEE ID = 106;

	DELETE FROM emp_details 
	WHERE EMPNO = 106;

--	3. UPDATE THE EMPLOYEE DEPARTMENT ID OF THE EMPLOYEEID = 108

	UPDATE emp_details 
	SET department_id= 20
	WHERE EMPNO = 108;  -- Error Code: 1054. Unknown column 'department_id' in 'field list'

--	OBSERVE THE PARENT TABLE EMPLOYEES	
-- 		Observation: 105's salary updated, 106's record removed from Parent Table employees.
	
--Q7. CREATE A VIEW ON EMPLOYEES AND DEPARTMENT WITH DEPARTMENTID COMPARISON

	CREATE OR REPLACE VIEW emp_dept_view
	AS
	SELECT e.employee_id EMPNO, concat(e.first_name,' ',e.last_name) EMPNAME, e.salary EMPSALARY, d.department_name DEPARTMENT
	FROM employees e JOIN departments d ON e.department_id = d.department_id;

--1. TRY TO DO UPDATE 

	UPDATE emp_dept_view
	SET DEPARTMENT= 'Marketing'
	WHERE EMPNO = 200;
	

-- Trying to update/delete records based on fields not present in emp_dept_view doesn't work.
		
