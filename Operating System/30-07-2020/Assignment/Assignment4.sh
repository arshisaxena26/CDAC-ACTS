#  Q4.Write a program to check whether given no.is even or odd

#!/bin/bash

echo -n "Enter a number: "
read num

if [ $(($num%2)) -eq 0 ]
	then
	echo "Even"
else
	echo "Odd"
fi	
