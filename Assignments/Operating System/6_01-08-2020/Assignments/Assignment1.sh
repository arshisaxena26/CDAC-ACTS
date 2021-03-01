#  Q1. Write a shell script to rename all files in the current directory with numeric continuous value
#      (Warning: Do this in a personal folder. Don't use Home directory) 

#!/bin/bash

num=0
list=`ls ./`

for i in $list
	do
		mv $i $((num=$num+1))
	done	


