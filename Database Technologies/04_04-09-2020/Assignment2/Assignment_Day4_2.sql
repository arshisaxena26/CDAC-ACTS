--1.) Write a query in SQL to display the first name, last name, department number, and department name for each employee.
	
	SELECT e.first_name, e.last_name, e.department_id, d.department_name
	FROM employees e JOIN departments d ON e.department_id = d.department_id;

--2.) Write a query in SQL to display the first and last name, department, city, and state province for each employee
	
	SELECT e.first_name, e.last_name, d.department_name, l.city, l.state_province
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON d.location_id = l.location_id;

--3.) Write a query in SQL to display the first name, last name, salary, and job grade for all employees.
	
	SELECT e.first_name, e.last_name, e.salary, j.job_id
	FROM employees e JOIN jobs j ON e.job_id = j.job_id;

--4.) Write a query in SQL to display the first name, last name, department number and department name, for all employees for departments 80 or 40.
	SELECT e.first_name, e.last_name, e.department_id, d.department_name
	FROM employees e JOIN departments d ON e.department_id = d.department_id
    	WHERE d.department_id IN (80,40);

--5.) Write a query in SQL to display those employees who contain a letter z to their first name and also display their last name, department, city, and state province.

	SELECT e.first_name, e.last_name, d.department_name, l.city, l.state_province
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON d.location_id = l.location_id
   	WHERE e.first_name like '%z%';

--6.) Write a query in SQL to display all departments including those which does not have any employee. 

	SELECT DISTINCT d.* 
	FROM departments d LEFT OUTER JOIN employees e ON d.department_id = e.department_id;
	
--7.) Write a query in SQL to display the first and last name and salary for those employees who earn less than the employee earn whose number is 182.
	
	SELECT e.first_name, e.last_name, e.salary
	FROM employees e JOIN (SELECT * FROM employees WHERE employee_id=182) AS s ON e.salary < s.salary;
	
--8.) Write a query in SQL to display the first name of all employees including the first name of their manager. 
	
	SELECT e.first_name AS 'Employee Name', m.first_name AS 'Manager Name'
	FROM employees e JOIN employees m ON e.manager_id = m.employee_id;

--9.) Write a query in SQL to display the department name, city, and state province for each department. 
	
	SELECT d.department_name, l.city, l.state_province
	FROM departments d JOIN locations l ON d.location_id = l.location_id;

--10.) Write a query in SQL to display the first name, last name, department number and name, for all employees who have or have not any department. 
	
	SELECT e.first_name, e.last_name, e.department_id, d.department_name
	FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id;

--11.) Write a query in SQL to display the first name of all employees and the first name of their manager including those who does not work under any manager.

	SELECT e.first_name AS 'Employee Name', m.first_name AS 'Manager Name'
	FROM employees e LEFT OUTER JOIN employees m ON e.manager_id = m.employee_id;
	
--12.) Write a query in SQL to display the first name, last name, and department number for those employees who works in the same department as the employee who holds the last name as Taylor.
	
	SELECT e.first_name, e.last_name, e.department_id
	FROM employees e JOIN (SELECT * FROM employees where last_name='taylor') AS t 
				ON e.department_id = t.department_id;	

--13.) Write a query in SQL to display the job title, department name, full name (first and last name ) of employee, and starting date for all the jobs which started on or after 1st January, 1993 and ending with on or before 31 August, 1997.
	
	SELECT j.job_title, d.department_name, e.first_name, e.last_name, h.start_date
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN jobs j ON j.job_id = e.job_id
    	JOIN job_history h ON h.job_id = e.job_id
	WHERE h.start_date BETWEEN '1993-01-01' AND '1997-08-31' ;
	
--14.) Write a query in SQL to display job title, full name (first and last name ) of employee, and the difference between maximum salary for the job and salary of the employee.

	SELECT j.job_title, e.first_name, e.last_name, j.max_salary-e.salary Difference
	FROM jobs j JOIN employees e ON j.job_id = e.job_id;
	
--15.) Write a query in SQL to display the name of the department, average salary and number of employees working in that department who got commission.

	SELECT d.department_name, avg(e.salary),count(e.commission_pct)
	FROM employees e JOIN departments d ON e.department_id = d.department_id
 	WHERE e.commission_pct > 0
	GROUP BY d.department_name;

--16.) Write a query in SQL to display the full name (first and last name ) of employees, job title and the salary differences to their own job for those employees who is working in the department ID 80.

		SELECT e.first_name, e.last_name, j.job_title, eighty.salary-e.salary Difference
		FROM employees e JOIN jobs j ON e.job_id = j.job_id
		JOIN (SELECT department_id, avg(salary) salary FROM employees 
			WHERE department_id = 80
			GROUP BY department_id) AS eighty ON e.salary != eighty.salary;

--17.) Write a query in SQL to display the name of the country, city, and the departments which are running there.
	
	SELECT c.country_name, l.city, d.department_name
 	FROM countries c JOIN locations l ON c.country_id = l.country_id
 	JOIN departments d ON d.location_id = l.location_id;

--18.) Write a query in SQL to display department name and the full name (first and last name) of the manager
	
	SELECT DISTINCT d.department_name, m.first_name, m.last_name
	FROM employees e JOIN employees m ON e.manager_id = m.employee_id
    	JOIN departments d ON m.department_id = d.department_id;

--19.) Write a query in SQL to display job title and average salary of employees.
	
	SELECT j.job_title, avg(salary)
	FROM jobs j JOIN employees e ON j.job_id = e.job_id
	GROUP BY j.job_title; 

--20.) Write a query in SQL to display the details of jobs which was done by any of the employees who is presently earning a salary on and above 12000.
	
	SELECT DISTINCT j.*
	FROM jobs j JOIN employees e ON j.job_id = e.job_id
	WHERE e.salary >= 12000;

--21.) Write a query in SQL to display the country name, city, and number of those departments where at least 2 employees are working.

	SELECT c.country_name, l.city, temp.department_name, temp.count_emp
	FROM countries c JOIN locations l ON c.country_id = l.country_id	
	JOIN (SELECT d.department_id, department_name, count(*) AS count_emp, location_id
		FROM employees e JOIN departments d ON e.department_id = d.department_id
		GROUP BY d.department_id) AS temp ON temp.location_id = l.location_id
	WHERE temp.count_emp >= 2;

--22.) Write a query in SQL to display the department name, full name (first and last name) of manager, and their city.

	SELECT DISTINCT d.department_name, m.first_name, m.last_name, l.city
	FROM employees e JOIN employees m ON e.manager_id = m.employee_id
	JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON d.location_id = l.location_id;

--23.) Write a query in SQL to display the employee ID, job name, number of days worked in for all those jobs in department 80.
	
	SELECT e.employee_id, j.job_title, to_days(h.end_date)-to_days(h.start_date) 'Days Worked'
	FROM employees e JOIN jobs j ON e.job_id = j.job_id
    	JOIN job_history h ON h.job_id = e.job_id
	WHERE e.department_id = 80;

--24.) Write a query in SQL to display the full name (first and last name), and salary of those employees who working in any department located in London.
	
	SELECT e.first_name, e.last_name, e.salary
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON l.location_id = d.location_id
	WHERE l.city = 'London';

--25.)  Write a query in SQL to display full name(first and last name), job title, starting and ending date of last jobs for those employees that worked without a commission percentage.

	SELECT e.first_name, e.last_name, j.job_title, h.start_date, h.end_date
    	FROM employees e JOIN jobs j ON e.job_id = j.job_id
    	JOIN job_history h ON h.job_id = j.job_id
    	WHERE e.commission_pct IS NULL;

--26.) Write a query in SQL to display the department name and number of employees in each of the department.
	
	SELECT d.department_name,count(*) 'Employee Count'
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	GROUP BY d.department_name;

--27.) Write a query in SQL to display the full name (firt and last name ) of employee with ID and name of the country presently where (s)he is working.

	SELECT e.first_name, e.last_name, e.employee_id, c.country_name
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	JOIN locations l ON l.location_id = d.location_id
	JOIN countries c ON c.country_id = l.country_id;

