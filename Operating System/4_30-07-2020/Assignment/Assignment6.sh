#   Q6. Write a script to check the type of a triangle. Sides of the triangle should be provided as command line arguments.

#!/bin/bash

if [ $1 -eq $2 -a $1 -eq $3 ]
then
	echo "Equilateral Triangle"
elif [ $1 -eq $2 -o  $1 -eq $3 -o $2 -eq $3 ]
then
	echo "Isosceles Triangle"
else
	echo "Scalene Triangle"
fi	
