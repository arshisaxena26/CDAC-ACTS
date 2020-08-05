#   Q9. Write a script to replace occurrence of given string in file.

#!/bin/bash

echo "Enter File Name"
read file

if [ -f $file ]
then	
	echo "Enter String to replace"
	read string

	echo "Enter string to replace $string with"
	read new

	sed "s/$string/$new/g" $file
else
	echo "File doesn't exist"
fi	
