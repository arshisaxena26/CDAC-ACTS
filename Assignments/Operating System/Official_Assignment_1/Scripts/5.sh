#  Q5. Create a script that asks for a file name or path and displays if file is world executable or not.

#!/bin/bash

echo "Enter File name or path"
read file

str=`ls -l $file`
s=`echo ${str:9:1}`

if [ $s = x ]
	then
	echo "File is World Executable"
else
	echo "File is NOT World Executable"
fi	
