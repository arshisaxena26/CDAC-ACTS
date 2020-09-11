-- DBT Official INTERNAL Assignment 1

-- Q1) Write SECECT statement to achieve the following:             
-- [1 marks each]

-- 1. Display the Employee’s ID, Column with concatenation of First Name and Last Name, Salary who is living in ‘London’.
	
	SELECT employee_id,concat(first_name,' ',last_name) 'Employee Name',salary
	FROM emp_details_view WHERE location_id = (SELECT location_id FROM emp_details_view WHERE city = 'London');
 
-- 2. Display the Employee’s Last name whose first name starts with ‘s’.

	SELECT last_name FROM employees 
	WHERE first_name like 's%';
 
-- 3. Find the Employee Joining date in first Monday in October month.
	
	SELECT hire_date
	FROM employees 
	WHERE monthname(hire_date)= 'October'
	AND dayofmonth(hire_date) <= 7
	AND dayofweek(hire_date) = 2;		
	 
-- 4. Display the Employee name and city in capital letter.
	
	SELECT upper(first_name), upper(last_name), upper(city)
	FROM emp_details_view;		
	 
-- 5. Display the department and their max salary of same department. 
	
	SELECT d.department_name, max(e.salary) MAX_SAL
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	GROUP BY d.department_name;

-- Q2) Find the second lowest salary among the employees, who are working in the same department.
-- [2 Marks]
	
	SELECT temp.department_id, ifnull(temp.second_lowest_sal,'NA') second_lowest_salary
 	FROM (SELECT department_id, (SELECT salary FROM employees e2
					WHERE e1.department_id = e2.department_id 
					ORDER BY salary 
                        		LIMIT 1,1) AS second_lowest_sal
		FROM employees e1
		WHERE department_id IS NOT NULL 
		GROUP BY department_id) AS temp;
	

-- Q3) Create a report have employees name, department name and job id have salary in range 10000 to 25000 and  department = 90.
-- [2 Marks]

	SELECT concat(first_name,' ',last_name) 'Employee Name', d.department_name, e.job_id
	FROM employees e JOIN departments d ON e.department_id = d.department_id
	WHERE salary BETWEEN 10000 AND 25000 
	AND e.department_id = 90;
	

-- Q4)  Display job title, employee name, and the difference between salary of the employee and minimum salary for the job.
-- [2 Marks]

	SELECT DISTINCT temp.job_title, concat(emp.first_name,' ',emp.last_name) 'Employee Name', emp.salary-MIN_SAL Difference
	FROM employees emp JOIN (SELECT j.job_id,j.job_title, min(salary) MIN_SAL
				FROM employees e JOIN jobs j ON e.job_id = j.job_id
				GROUP BY job_id) AS temp 
			ON emp.job_id = temp.job_id;

-- Q5) Write a query to display department name, name (first_name, last_name), hiredate, salary of the manager for all managers whose experience is more than 15 years.
-- [2 Marks]

	SELECT d.department_name, concat(e.first_name,' ',e.last_name) 'Employee Name', e.hire_date, m.salary
	FROM employees e JOIN employees m ON e.manager_id = m.employee_id
	JOIN departments d ON e.department_id = d.department_id
	WHERE year(current_date) - year(m.hire_date) > 15;

--Q6) Create a report to display the manager number and the salary of the lowest-paid employee for that manager. Exclude anyone whose manager is not known. Exclude any groups where the minimum salary is $6,000 or less. Sort the output in descending order of salary.
--[2Marks]

	SELECT manager_id, min(salary) MIN_SAL
	FROM employees
	WHERE manager_id IS NOT NULL
	GROUP BY manager_id 
	HAVING MIN_SAL > 6000
	ORDER BY MIN_SAL desc;

