--1. List department details in which no employee is working.
	
	SELECT * FROM DEPT d
	WHERE NOT EXISTS (SELECT * FROM EMP e 
				WHERE d.DEPTNO = e.DEPTNO);

--2. Find list of employees which are earning less then avg salary of their department
	
	SELECT ENAME FROM EMP e
	WHERE EXISTS (SELECT e1.DEPTNO, avg(e1.SAL) AVG_SAL 
			FROM EMP e1
               		WHERE e.DEPTNO = e1.DEPTNO 
                	GROUP BY e1.DEPTNO 
                	HAVING e.SAL < AVG_SAL);

--3. Display list of employees which are earning more than the corresponding manager.
	
	SELECT ENAME FROM EMP e
	WHERE EXISTS (SELECT * FROM EMP e1 
			WHERE e.MGR = e1.EMPNO AND e.SAL > e1.SAL);	

--4. Display list of employees which are not managed by anyone

	SELECT ENAME FROM EMP e
	WHERE EXISTS (SELECT * FROM EMP e1 
			WHERE MGR IS NULL AND e.EMPNO = e1.EMPNO)

--5. Display department details where avg salary is more than 1000

	SELECT * FROM DEPT d
	WHERE EXISTS (SELECT e.DEPTNO, avg(SAL) AVG_SAL
			FROM EMP e
                	WHERE d.DEPTNO = e.DEPTNO
			GROUP BY e.DEPTNO
			HAVING AVG_SAL > 1000);


	

