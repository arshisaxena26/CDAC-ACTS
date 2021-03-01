-- Procedure Assignment

--Q1:- Write a store procedure to get the level based on the employee's id.

--      Level Definition:-

--           Salary >  20000  - Consider them 'MANAGER'

--           Salary between 15000 and 20000 - Consider them 'LEADS'

--           Salary between 8000 and 15000 - Consider then 'SENIOR DEVELOPER'

--           Salary < 8000 - Consider them 'FRESHERS'

--            Conditions:-  Use at least one IN variable and one OUT variable

	DELIMITER #
	CREATE PROCEDURE getLevel(p_empid INT, OUT p_level VARCHAR(20))
	BEGIN
	
	DECLARE emp_sal INT;
	SELECT salary INTO emp_sal FROM employees WHERE employee_id = p_empid;

	IF emp_sal > 20000 THEN
		SET p_level = 'MANAGER';
	ELSEIF emp_sal BETWEEN 15001 AND 20000 THEN
		SET p_level = 'LEADS';
	ELSEIF emp_sal BETWEEN 8001 AND 15000 THEN
		SET p_level = 'SENIOR DEVELOPER';
	ELSE
		SET p_level = 'FRESHERS';
	END IF;
	END#              

--Q2:- Write a store procedure to get the numbers from 1 to 10 in words.

--       Like: 

--         1    --    ONE

--         2    --    TWO

 --        3    --    THREE...

--      Conditions:- Use CASE operator with IN parameter    

	DELIMITER #
	CREATE PROCEDURE numberToWords(p_num INT)
	BEGIN

	CASE
	WHEN p_num = 1 THEN SELECT 'ONE';
	WHEN p_num = 2 THEN SELECT 'TWO';
	WHEN p_num = 3 THEN SELECT 'THREE';
	WHEN p_num = 4 THEN SELECT 'FOUR';
	WHEN p_num = 5 THEN SELECT 'FIVE';
	WHEN p_num = 6 THEN SELECT 'SIX';
	WHEN p_num = 7 THEN SELECT 'SEVEN';
	WHEN p_num = 8 THEN SELECT 'EIGHT';
	WHEN p_num = 9 THEN SELECT 'NINE';
	WHEN p_num = 10 THEN SELECT 'TEN';
	ELSE SELECT 'NUMBER OUT OF RANGE';
	END CASE;

	END#

--Q3:- Write a Fibonacci Series bypassing the length of the series required

--    Like:

--       4    --    0    1    1    2

--       8    --    0    1    1    2    3    5    8    13

--   Conditions:-  Use WHILE EXPRESSSION - DO     

	DELIMITER #
	CREATE PROCEDURE fibonacciSeries
	(
		p_length INTEGER
	)
	BEGIN
		DECLARE num1,num2,sum,count INTEGER;
	    	SET num1=0, num2=1, count=0;
	    
	    	WHILE count < p_length DO
			IF count = 0 THEN
				SET sum = num1;
			ELSEIF count = 1 THEN
				SET sum = num2;
			ELSE 
				SET sum = num1 + num2;
		    		SET num1 = num2;
		    		SET num2 = sum;
			END IF;
	    
	    	SET count = count + 1;    
	    	SELECT sum;
	    
	    	END WHILE;
	END#

--Q4:- Write the Factorial program to display the 

--  Factorial String and Value

--  Like: Factorial of 5 is 120

--  	  Factorial String:    1*2*3*4*5

--  	  Factorial Value:    120

--  Conditions:- Use Repeat --> Until

	DELIMITER #
	CREATE PROCEDURE factorial
	(
		p_number INTEGER
	)
	BEGIN
		DECLARE result_value,count INTEGER;
	    	DECLARE prev_str,result_str VARCHAR(200);
	    	SET count=1, result_value=1, prev_str='';
	    
	    REPEAT
		SET result_value = result_value * count;
		SET result_str = concat(prev_str,count,'*');
		SET count = count + 1;
		SET prev_str = result_str;
	    
	    UNTIL count > p_number
	    END REPEAT;
	    
	    SELECT result_str AS 'Factorial String', result_value AS 'Factorial Value';
	END#


