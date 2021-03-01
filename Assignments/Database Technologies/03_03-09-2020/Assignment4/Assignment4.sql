--1. Display all the Suppliers with the same Status as the supplier, ‘CLARK’.
	
	SELECT SNAME FROM suppliers
	WHERE STATUS=(SELECT STATUS FROM suppliers 
			WHERE SNAME='CLARK');

--2. Display all the Employees in the same department as the employee ‘MILLER’.

	SELECT ENAME FROM EMP
	WHERE DEPTNO=(SELECT DEPTNO FROM EMP 
			WHERE ENAME='MILLER');

--3. Display all the Parts which have more Weight than all the Red parts.
	
	SELECT * FROM parts
	WHERE WEIGHT > ALL (SELECT WEIGHT FROM parts 
				WHERE COLOR='Red');

--4. Display all the Parts with Weight less than all the Green parts.
	
	SELECT * FROM parts
	WHERE WEIGHT < (SELECT WEIGHT FROM parts 
			WHERE COLOR='Green');

--5. Display the name of the Supplier who has sold the maximum Quantity (in one sale).
	
	SELECT SNAME FROM suppliers
	WHERE SNUM IN (SELECT SNUM FROM orders
			GROUP BY SNUM
                	HAVING max(QTY) = (SELECT max(MAX_QTY) FROM (SELECT SNUM, max(QTY) MAX_QTY
									FROM orders
									GROUP BY SNUM) AS TEMP));

--6. Display the name of the Employee with the minimum Salary.

	SELECT ENAME FROM EMP
		WHERE SAL = (SELECT min(SAL) FROM EMP);

--7. Display the name of the Supplier who has sold the maximum overall Quantity (sum of Sales).
	
	SELECT SNAME FROM suppliers
	WHERE SNUM IN (SELECT SNUM FROM orders
			GROUP BY SNUM
                	HAVING sum(QTY) = (SELECT max(SUM_QTY) FROM (SELECT SNUM, sum(QTY) SUM_QTY
									FROM orders
									GROUP BY SNUM) AS TEMP));

--8. Display the name of the Department with the maximum number of Employees.

	SELECT DNAME FROM DEPT
	WHERE DEPTNO = (SELECT DEPTNO FROM EMP 
			GROUP BY DEPTNO 
                    	HAVING count(*)= (SELECT MAX(COUNT_ID)
						FROM (SELECT COUNT(*) AS COUNT_ID
							FROM EMP
	                                                GROUP BY DEPTNO) AS TEMP));
