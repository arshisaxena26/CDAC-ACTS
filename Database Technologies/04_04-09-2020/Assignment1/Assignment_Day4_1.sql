--1) Display all records in EMP table those were joined before SCOTT joined?
	
	SELECT emp.* 
	FROM EMP emp JOIN EMP scott ON emp.HIREDATE < scott.HIREDATE
	WHERE scott.ENAME='SCOTT'; 
	
--2) Display details of department where department has 3 employees?

	SELECT * FROM DEPT
    	WHERE DEPTNO= (SELECT d.DEPTNO
			FROM DEPT d JOIN EMP e ON d.DEPTNO=e.DEPTNO
    			GROUP BY d.DEPTNO
    			HAVING count(d.DEPTNO)=3);	

--3) Display details of department with Minimum salary and maximum salary?

	SELECT d.*
	FROM DEPT d JOIN EMP e ON d.DEPTNO=e.DEPTNO
	WHERE e.SAL = (SELECT max(SAL) FROM EMP) OR e.SAL = (SELECT min(SAL) FROM EMP);


--4) Display all ename, sal, deptno,dname from emp, dept table where all department which has employees as well as department does not have any employees. This query should include non matching rows.

	SELECT ENAME,SAL,d.DEPTNO,DNAME
	FROM DEPT d LEFT OUTER JOIN EMP e ON d.DEPTNO = e.DEPTNO;


--5) Display all ename, sal, deptno from emp, dept table where all employees which has matching department as well as employee does not have any departments. This query should include non matching rows.

	SELECT ENAME,SAL,e.DEPTNO
	FROM EMP e LEFT OUTER JOIN DEPT d ON e.DEPTNO = d.DEPTNO;

--6) Display all ename, sal, dname. Result must include all employees as well as all departments. This query should include non matching rows on both the tables.

	SELECT ENAME,SAL,DNAME
	FROM EMP e RIGHT OUTER JOIN DEPT d ON e.DEPTNO = d.DEPTNO
 	UNION
 	SELECT ENAME,SAL,DNAME
	FROM EMP e LEFT OUTER JOIN DEPT d ON e.DEPTNO = d.DEPTNO;
	
--7) Display all ename, empno, dname from emp, dept table without joining two tables

	SELECT ENAME,EMPNO,DNAME
	FROM EMP e,DEPT d
   	WHERE e.DEPTNO = d.DEPTNO;

--8) Display all the departments where department does not have any employees
	
	SELECT d.* 
	FROM DEPT d LEFT OUTER JOIN EMP e ON d.DEPTNO = e.DEPTNO
	WHERE e.DEPTNO IS NULL;

--9) Display all the departments where department does have atleast one employee

	SELECT DISTINCT d.* 
	FROM DEPT d JOIN EMP e ON d.DEPTNO = e.DEPTNO;

--10) Display all employees those who are not managers?
	
	SELECT e.ENAME
	FROM EMP e LEFT OUTER JOIN EMP m ON e.EMPNO = m.MGR
	WHERE m.MGR IS NULL;

--11) Display all the records for deptno which belongs to employee name JAMES?
	
	SELECT d.* 
	FROM DEPT d JOIN EMP e ON d.DEPTNO=e.DEPTNO
	WHERE e.ENAME='JAMES';	

--12) Display all the records in emp table where salary should be less then or equal to ADAMS salary?
	
	SELECT e.*
	FROM EMP e LEFT OUTER JOIN (SELECT * FROM EMP WHERE ENAME='ADAMS') AS adams ON e.SAL <= adams.SAL
	WHERE adams.SAL IS NOT NULL;

--13) Display ename, sal, grade, dname, loc for each employee.

	SELECT DISTINCT e.ENAME,e.SAL,s.GRADE,d.DNAME,d.LOC
	FROM EMP e LEFT OUTER JOIN DEPT d ON e.DEPTNO=d.DEPTNO
	JOIN SALGRADE s ON e.SAL BETWEEN s.LOSAL AND s.HISAL;
	
--14) Display all employee whose location is DALLAS?

	SELECT e.ENAME,d.LOC
 	FROM EMP e JOIN DEPT d ON e.DEPTNO = d.DEPTNO
 	WHERE d.LOC = 'DALLAS';
