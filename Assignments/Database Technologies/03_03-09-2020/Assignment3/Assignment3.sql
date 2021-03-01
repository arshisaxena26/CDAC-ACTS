--1. Display the minimum Status in the Supplier table.

	SELECT min(STATUS) FROM suppliers;

--2. Display the maximum Weight in the Parts table.

	SELECT max(WEIGHT) FROM parts;

--3. Display the average Weight of the Parts.
	
	SELECT avg(WEIGHT) FROM parts;

--4. Display the total Quantity sold for part ‘P1’.

	SELECT sum(QTY) Quantity FROM orders WHERE PNUM=1;

--5. Display the total Quantity sold for each part.
	
	SELECT PNUM, sum(QTY) Quantity 
	FROM orders
	GROUP BY PNUM;

--6. Display the average Quantity sold for each part.
	
	SELECT PNUM, avg(QTY) Quantity 
	FROM orders
	GROUP BY PNUM;
	
--7. Display the maximum Quantity sold for each part, provided the maximum Quantity is greater than 800.
	
	SELECT PNUM, max(QTY) Quantity 
	FROM orders
	GROUP BY PNUM
	HAVING Quantity > 800;

--8. Display the Status and the count of Suppliers with that Status.
	
	SELECT STATUS,count(*) 
	FROM suppliers
	GROUP BY STATUS;

--9. What is the difference between COUNT(Status) and COUNT(*) ?

--	count(STATUS) : Count of records in STATUS column.
--	count(*) : Count of records in suppliers Table.

--10. Display the Status and the Count of Suppliers with that Status in the following format as shown below:-

--	Status	Count
--	Ten	1
--	Twenty	2
--	Thirty	3

	SELECT replace(replace(replace(STATUS,10,'Ten'),20,'Twenty'),30,'Thirty'), COUNT(*)
	FROM suppliers
	GROUP BY STATUS
	ORDER BY STATUS;
