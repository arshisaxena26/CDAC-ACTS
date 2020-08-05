# Q5. a) Write a script to find biggest of three no.s

#!/bin/bash

echo "Enter three numbers"
read a
read b
read c

if [ $a -gt $b -a $a -gt $c ]
	then
	echo "Largest:$a"
elif [ $b -gt $a -a $b -gt $c ]
	then
	echo "Largest:$b"
else
	echo "Largest:$c"
fi	
