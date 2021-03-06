--1. login to MySQL

     mysql -u root -p

--2. list different database in MySQL

     SHOW databases;

--3. How to connect to specific database

     USE [dbname];

--4. List all the tables available in given database

     SHOW tables;

--5. Switch from one database to other

     USE [dbname];

--6. Run the script "SampleScott_Schema.sql" in your database

     CREATE database assignment1;
     USE assignment1;
     SOURCE /home/path/SampleScott_Schema.sql ;

--7. List the tables that you have in the database now

     SHOW tables;

--8. Describe the structure of each table in MySQL

     desc BONUS;
     desc DEPT;
     desc DUMMY;
     desc EMP;
     desc SALGRADE;

--9. Export the table data in external file in MySQL

     SELECT * 
          FROM EMP 
		into outfile '/var/lib/mysql-files/table.txt';

--10. Show the data from each table in MySQL

     SELECT * FROM BONUS;
     SELECT * FROM DEPT;
     SELECT * FROM DUMMY;
     SELECT * FROM EMP;
     SELECT * FROM SALGRADE;

--11. Interact with MySQL WorkBench Software

--12. Clear the MySQL command prompt

     CTRL+L (Linux)

--13. Fire command to check current user in database

     SELECT  user();

--14. Fire command to see current date and time of server

     SELECT  now();

--15. Fire command to assign the output to select command to variable in MySQL

     SELECT EMPNO 
		FROM EMP 
			WHERE EMPNO=7369 into @variable;

--16. Print the value stored in variable on the screen

     SELECT @variable;

--17. Observe the output of command "select DATE(current_date() +2),current_date();"

--	+-------------------------+----------------+
--	| DATE(current_date() +2) | current_date() |
--	+-------------------------+----------------+
--	| 2020-09-04              | 2020-09-02     |
--	+-------------------------+----------------+

--18. Observe the command "select null;"
--      Identify what is null
	  
--	+------+
--	| NULL |
--	+------+
--	| NULL |
--	+------+




