#   Q2.Write a script to check whether given argument is a regular file or directory

#!/bin/bash

echo "Enter name"
read name

if [ -d ${name} ]
	then
	echo "$name is a Directory."
elif [ -f ${name} ]
	then
	echo "$name is a File"
else
	echo "$name doesn't exist"
fi	
