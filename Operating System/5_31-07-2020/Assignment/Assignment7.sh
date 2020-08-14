#  Q7. Write a script to find substring inside a file

#!/bin/bash

echo -n "Enter File Name: "
read file

echo "Enter Substring"
read sub

if [ -f $file ]
then
	
	match=`grep $sub $file | wc -w`
	
	if [ $match -ne 0  ]
	then
		echo "Substring Present"
	else
		echo "Substring Absent"
	fi	

else
	echo "File doesn't exist"
fi	


