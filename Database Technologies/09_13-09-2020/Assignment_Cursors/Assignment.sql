--Cursors
---------

--1. Prepare a program to display the comma separated list of employee names in following format

/*   Deptno    Employees
   -------   ------------
   10        Scott, Smith, Jones
   20        Allen, Ford
   30 
*/

	DELIMITER #
	CREATE PROCEDURE deptEmp()
	BEGIN
	    DECLARE dno INTEGER;
	    DECLARE emp_names VARCHAR(100);
	    DECLARE records_notfound BOOLEAN DEFAULT FALSE;
	    
	    DECLARE c_records CURSOR FOR SELECT DEPTNO, group_concat(ENAME) FROM EMP GROUP BY DEPTNO;
	    DECLARE continue HANDLER FOR NOT FOUND SET records_notfound = TRUE;
	    
	    OPEN c_records;
	    
	    cur_loop: LOOP
		FETCH c_records INTO dno,emp_names;
		
		IF records_notfound THEN
			LEAVE cur_loop;
		END IF;
		
		SELECT dno,emp_names;

	    END LOOP cur_loop;
	    
	    CLOSE c_records;
	END#

--2. Prepare a program to show the details in following format

/*    Deptno   Dname      Employees
	-------  -------    -------------
	10        SALES     Scott, Smith, Jones
*/

	DELIMITER #
	CREATE PROCEDURE empDetails()
	BEGIN
	    DECLARE dno INTEGER;
	    DECLARE emp_names VARCHAR(100);
	    DECLARE dept_name VARCHAR(10);
	    DECLARE records_notfound BOOLEAN DEFAULT FALSE;
	    
	    DECLARE c_records CURSOR FOR SELECT DEPTNO,
					    group_concat(ENAME) Employees,
					    (SELECT DNAME FROM DEPT d WHERE e.DEPTNO = d.DEPTNO) AS Dname
				     FROM EMP e GROUP BY DEPTNO;

	    DECLARE continue HANDLER FOR NOT FOUND SET records_notfound = TRUE;
	    
	    OPEN c_records;
	    
	    cur_loop: LOOP
			FETCH c_records INTO dno,emp_names,dept_name;
		
		IF records_notfound THEN
			LEAVE cur_loop;
		END IF;
		
		SELECT dno,emp_names,dept_name;
	    END LOOP cur_loop;
	    
	    CLOSE c_records;
	END#
	
--3. For performance testing we are trying to increase number of records by 10 times for each department. For eg: If there are 3 employees in dept 10 then we should be able to increase the employee count to 30 using same / random values 

/* eg:

+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |


should become


+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7783 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7784 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7785 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7786 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7787 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
...........
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7840 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7841 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7842 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7843 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7844 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
...........
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
	
*/	

	DELIMITER #
	CREATE PROCEDURE dupData()
	BEGIN
	    DECLARE emp_no,mgr_no,emp_sal,emp_comm,dept_no,record_no INTEGER;
	    DECLARE emp_name,emp_job VARCHAR(10);
	    DECLARE hire_date DATE;
	    DECLARE records_notfound BOOLEAN DEFAULT FALSE;
	    
	    DECLARE c_records CURSOR FOR SELECT * FROM EMP;
	    DECLARE continue HANDLER FOR NOT FOUND SET records_notfound = TRUE;
	    
	    CREATE TABLE IF NOT EXISTS emp_test LIKE EMP;
	    OPEN c_records;
	    
	    cur_loop: LOOP
		SET record_no = 0;
		FETCH c_records INTO emp_no,emp_name,emp_job,mgr_no,hire_date,emp_sal,emp_comm,dept_no;
		
		IF records_notfound THEN
			LEAVE cur_loop;
		END IF;
		
		WHILE record_no < 10 DO
			INSERT INTO emp_test VALUES(emp_no,emp_name,emp_job,mgr_no,hire_date,emp_sal,emp_comm,dept_no);
		    	SET record_no = record_no + 1;
		END WHILE;    
		
	    END LOOP cur_loop;
	    
	    CLOSE c_records;
	END#
	
--4. Prepare a program to create clone of all tables in given schema

	DELIMITER #
	CREATE PROCEDURE cloneTables
	(
		p_schemaName VARCHAR(25)
	)

	BEGIN
		DECLARE table_names VARCHAR(20);
	    	DECLARE records_notfound BOOLEAN DEFAULT FALSE;
	    	DECLARE c_tables CURSOR FOR SELECT table_name FROM information_schema.tables 
					     WHERE table_schema = p_schemaName;
	    
	    	DECLARE continue HANDLER FOR NOT FOUND SET records_notfound = TRUE;

	    	OPEN c_tables;
	    
	    	cur_loop: LOOP
			FETCH c_tables INTO table_names;
		
			IF records_notfound THEN
				LEAVE cur_loop;
			END IF;
		
			SET @create_table_clone = concat('CREATE TABLE ',table_names,'_clone AS SELECT * FROM ',table_names);
			PREPARE stmt FROM @create_table_clone;
			EXECUTE stmt;
			DEALLOCATE PREPARE stmt;
		
	    	END LOOP cur_loop;
	    
	    	CLOSE c_tables;
	END#

