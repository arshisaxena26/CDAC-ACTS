#4.Write a script to create 10 directories, say exam1,exam2,...,exam10 Report error if a directory/file exists with the same name.

#!/bin/bash

list=`seq 1 1 10`
string="exam"

for x in $list
	do
		if [ -d $string$x -o -f $string$x ]
		then
			echo "Error:$string$x Directory/File already exists"
			continue
		else
			mkdir $string$x
		fi
	done
	
