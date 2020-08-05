#  Q5.Write a script to check each entry of a directory is a file or directory.

#!/bin/bash

list=`ls`

for x in $list
	do
		if [ -d $x ]
		then
			echo "$x is a directory"
		else
			echo "$x is a file"
		fi
	done	
