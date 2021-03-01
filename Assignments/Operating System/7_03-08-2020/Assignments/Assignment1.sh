#  Q1. Write a shell script to append the numbers in all filenames  of current directory(Don’t use home directory.)

#!/bin/bash

list=`ls`
num=0

for i in $list
	do
		mv $i $i$((num=$num+1))
	done	
