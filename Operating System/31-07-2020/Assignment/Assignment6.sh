#   Q6.Write a script to find substring inside a string

#!/bin/bash

echo "Enter a String"
read string

echo "Enter the substring to find in the string"
read sub

if [[ "$string" == *"$sub"* ]]
	then
	echo "Substring is present"
else
	echo "Substring not present"
fi	
