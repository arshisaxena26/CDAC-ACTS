--1. Display the Supplier table in the descending order of CITY.

	SELECT * FROM suppliers
		ORDER BY CITY desc;

--2. Display the Part Table in the ascending order of CITY and within the city in the ascending order of Part names.
	
	SELECT * FROM parts
		ORDER BY CITY asc,PNAME asc;	

--3. Display all the Suppliers with a status between 10 and 20.

	SELECT SNAME FROM suppliers
		WHERE STATUS IN (10,20);

--4. Display all the Parts and their Weight, which are not in the range of 10 and 15.

	SELECT PNAME,WEIGHT
		FROM parts
			WHERE WEIGHT NOT BETWEEN 10 AND 15;

--5. Display all the Part names starting with the letter ‘S’.

	SELECT DISTINCT PNAME FROM parts
		WHERE PNAME LIKE 'S%';

--6. Display all the Suppliers, belonging to cities starting with the letter ‘L’.

	SELECT SNAME,CITY FROM suppliers
		WHERE CITY LIKE 'L%';


