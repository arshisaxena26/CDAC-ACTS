--1) Display all the records in emp table?

	SELECT * FROM EMP;

--2) Display all the records in emp table where employee belongs to deptno 10?

	SELECT * FROM EMP WHERE DEPTNO=10;

--3) Display all the records in emp table where employee does not belong to deptno 30?

	SELECT * FROM EMP WHERE DEPTNO!=10;

--4) Display total number of records in Emp table?

	SELECT count(*) FROM EMP;

--5) Display emp table with salary descending order?

	SELECT * FROM EMP
		ORDER BY SAL desc;

--6) Display all the records in emp table order by ascending deptno, descending salary?

	SELECT * FROM EMP
		ORDER BY DEPTNO asc, SAL desc;

--7) Display all employees those who were joined in year 1981?

	SELECT ENAME,HIREDATE FROM EMP 
		WHERE HIREDATE BETWEEN '1981-01-01' AND '1981-12-31';

--8) Display COMM in emp table. Display zero in place of null.

	SELECT ifnull(COMM,0) FROM EMP;
		
--9) Display the records in emp table where MGR in 7698,7566 and sal should be greater then 1500

	SELECT * FROM EMP
		WHERE MGR IN (7698,7566) AND SAL > 1500;

--10) Display all employees where employees hired before 01-JAN-1981

	SELECT ENAME,HIREDATE FROM EMP
		WHERE HIREDATE < '1981-01-01';

--11) Display all employees with how many years they have been servicing in the company?

	SELECT ENAME, year(current_date())-year(HIREDATE) AS 'YEARS IN COMPANY'
		FROM EMP;

--12) Display all employees those were not joined in 1981?

	SELECT ENAME,HIREDATE
		FROM EMP
			WHERE year(HIREDATE) != '1981';

--13) Display all employees where their salary is less then the Ford’s salary?

	SELECT ENAME,SAL
		FROM EMP
			WHERE SAL < (SELECT SAL FROM EMP WHERE ENAME='FORD');

--14) Display all records in EMP table those were joined before SCOTT joined?

	SELECT * FROM EMP
		WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');

--15) Display all employees those who were joined in third quarter of 1981?

	SELECT ENAME,HIREDATE
		FROM EMP
			WHERE HIREDATE BETWEEN '1981-07-01' AND '1981-09-30';

--16) Write a query to display current date?

	SELECT current_date();

--17) Display distinct job from emp table?

	SELECT DISTINCT JOB FROM EMP;

--18) Display all the records in emp table where employee hired after 28-SEP-81 and before 03-DEC-81?

	SELECT * FROM EMP
		WHERE HIREDATE BETWEEN '1981-09-29' AND '1981-12-02';

--19) Write a query that displays the employee’s names with the first letter capitalized and all other letters lowercase for all employees whose name starts with J, A, or M

	SELECT concat( upper(substring(ENAME,1,1)), lower(right(ENAME,length(ENAME)-1)))  
 		FROM EMP
 			WHERE ENAME LIKE 'J%' OR ENAME LIKE 'A%' OR ENAME LIKE 'M%'; 

--20) Display the empno, ename, sal, and salary increased by 15%.

	SELECT EMPNO,ENAME,SAL, SAL+SAL*0.15 AS 'Salary After Increment'
		FROM EMP;

--21) Display all employees where ename start with J and ends with S

	SELECT ENAME FROM EMP
		WHERE ENAME LIKE 'J%S';

--22) Display all employees where employee does not belong to 10,20,40

	SELECT ENAME,DEPTNO 
		FROM EMP
			WHERE DEPTNO NOT IN (10,20,40);

--23) Display all employees where jobs does not belong to PRESIDENT and MANAGER?

	SELECT ENAME,JOB
		FROM EMP
			WHERE JOB NOT IN ('PRESIDENT','MANAGER');

--24) Display the maximum salary in the emp table

	SELECT max(SAL) FROM EMP;

--25) Display average salary for job SALESMAN

	SELECT avg(SAL),JOB
		FROM EMP
			WHERE JOB='SALESMAN';

--26) Display all three figures salary in emp table

	SELECT SAL FROM EMP
		WHERE SAL BETWEEN 100 AND 999;

--27) Display all records in emp table for employee who does not receive any commission

	SELECT * FROM EMP
		WHERE ifnull(COMM,0) = 0;

--28) Display all ename where first character could be anything, but second character should be L?

	SELECT ENAME FROM EMP
		WHERE ENAME LIKE '_L%';

--29) Display sum of salary for each department.

	SELECT DEPTNO,sum(SAL) FROM EMP
		GROUP BY DEPTNO;

--30) Display all department with Minimum salary and maximum salary?

	SELECT DEPTNO,min(SAL),max(SAL)
		FROM EMP
			GROUP BY DEPTNO;

--31) Display all the departments where department does not have any employees

	SELECT DNAME,DEPTNO FROM DEPT
   		WHERE DEPTNO NOT IN (SELECT DEPTNO FROM EMP GROUP BY DEPTNO);

--32) Display all the departments where department does have atleast one employee

	SELECT DNAME,DEPTNO FROM DEPT
    		WHERE DEPTNO IN (SELECT DEPTNO FROM EMP GROUP BY DEPTNO);

--33) Display all employees those who are not managers?

	SELECT ENAME FROM EMP
		WHERE EMPNO NOT IN (SELECT ifnull(MGR,0) FROM EMP);

--34) Display all the records for deptno which belongs to employee name JAMES?

	SELECT * FROM EMP
		WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='JAMES');

--35) Display all the records in emp table where salary should be less then or equal to ADAMS salary?

	SELECT * FROM EMP
		WHERE SAL <= (SELECT SAL FROM EMP WHERE ENAME='ADAMS');

--36) Display all employees those were joined before employee WARD joined?

	SELECT ENAME FROM EMP
		WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='WARD');

--37) Display all subordinate those who are working under BLAKE?

	SELECT ENAME FROM EMP
		WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='BLAKE');  

--38) Display all subordinate(all levels) for employee BLAKE?

	SELECT DISTINCT JOB FROM EMP
		WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='BLAKE');

--39) Display all record in emp table for deptno which belongs to KING's Job?

	SELECT * FROM EMP
		WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='KING'));	

--40) Display the employees for empno which belongs to job PRESIDENT?

	SELECT ENAME FROM EMP
		WHERE MGR=(SELECT EMPNO FROM EMP WHERE JOB='PRESIDENT');

--41) Display list of ename those who have joined in Year 81 as MANAGER?

	SELECT ENAME FROM EMP
		WHERE year(HIREDATE)='1981' AND JOB='MANAGER';

--42) Display who is making highest commission?

	SELECT ENAME,COMM FROM EMP
		WHERE COMM=(SELECT max(COMM) FROM EMP);

--43) Display who is senior most employee? How many years has been working?

	SELECT ENAME, year(current_date)-year(HIREDATE) AS 'Years in Company'
		FROM EMP
			WHERE HIREDATE = (SELECT min(HIREDATE) FROM EMP);

--44) Display who is most experienced and least experienced employee?

	SELECT ENAME,HIREDATE
		FROM EMP
			WHERE HIREDATE=(SELECT min(HIREDATE) FROM EMP) OR HIREDATE=(SELECT max(HIREDATE) FROM EMP);	

--45) Display all employee whose location is DALLAS?

	SELECT ENAME FROM EMP
		WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

--46) List ename, job, sal and department of all employees whose salary is not within the salary grade?

	SELECT ENAME,JOB,SAL,DEPTNO
		FROM EMP
			WHERE SAL NOT BETWEEN (SELECT min(LOSAL) FROM SALGRADE) AND (SELECT max(HISAL) FROM SALGRADE);


