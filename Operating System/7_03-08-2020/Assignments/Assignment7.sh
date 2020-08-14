#  Q7. Write a shell script to automate tasks:(It’s not menu driven. Follow operations in order)
#		a)Install wget
#		b)Download file https://www.kernel.org/doc/Documentation/switchtec.txt
#		c)open file with vi editor(Let user edit the file and save it)
#		d)https://www.kernel.org/doc/Documentation/switchtec.txt--Change all driver word occurrences  with DRIVER word in above file
#		e)Print it on terminal(wait for user to enter q to exit it)

#!/bin/bash

echo "--------INSTALLING wget--------------"
sudo apt install wget

echo "----------------DOWNLOADING FILE---------------"
wget https://www.kernel.org/doc/Documentation/switchtec.txt


vi switchtec.txt

sed "s/driver/DRIVER/g" switchtec.txt

echo "Enter q to exit"

while read quit && [ $quit != 'q'  ]
	do
		continue
	done	




