#  Q3.To check given year is leap or not

#!/bin/bash

echo "Enter year"
read year

if [ $(($year%4)) -eq 0 ]
then
	if [ $(($year%100)) -eq 0 ]
	then
		if [ $(($year%400)) -eq 0 ]
		then
			echo "Leap Year:$year"
		else
			echo "Not a Leap Year:$year"
		fi	
	else
		echo "Not a Leap Year:$year"
	fi	
else
	echo "Not a Leap Year:$year"
fi	
