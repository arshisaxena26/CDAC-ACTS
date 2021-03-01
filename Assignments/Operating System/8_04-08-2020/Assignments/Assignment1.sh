# Q1. Write a shell script to do following operation:
#		a)Start ssh service
#		b)copy readme.txt from test.rebex.net
#		c)Print readme.txt file on terminal
#		d)Find substr given by user in readme.txt and replace it with “****”

#!/bin/bash

sudo systemctl start ssh
scp demo@test.rebex.net:/readme.txt ./
cat readme.txt

echo " "
echo -n "Enter substring to be replaced with **** : "
read str

sed "s/$str/****/g" readme.txt
echo " "

