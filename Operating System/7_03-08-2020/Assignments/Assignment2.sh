#  Q2. Write a menu driven script:
#		a)Store student name in array
#		b)Search name in array
#		c)Search by first name

#!/bin/bash

Store()
{
	echo -n "Enter Student Name: "
	read Sname

	for i in "${StudentName[@]}"
		do
			if [ $i = $Sname ]
			then
				echo "Student Name Already Exists"
				return
			fi
		done

	StudentName+=("$Sname")
	echo "Student Name Added"
	echo " "
	}

Search()
{
	echo -n "Enter Student Name: "
	read name
	
	for i in "${StudentName[@]}"
		do
			if [[ "$i" == "$name"  ]]
			then
				echo "$name Found"
				echo " "
				return
			fi	
		done
	
	echo "$name NOT Found"
	echo " "

	}

SearchFN()
{
	echo -n "Enter Student's First Name: "
	read fname
	
	for i in "${StudentName[@]}"
		do
			firstName=`echo $i | cut -d " " -f1`

			if [ $firstName = $fname ]
			then
				echo "First Name Found"
				echo " "
				return
			fi
		done

	echo "First Name NOT Found"
	echo " "
	}

declare -a StudentName
while [ "true" ]
	do
		echo "***********OPTIONS************"
		echo "1. Store Student Name"
		echo "2. Search Student Name"
		echo "3. Search by First Name"
		echo "4. Exit"

		read ch

		case $ch in

		1) Store;;
		2) Search;;
		3) SearchFN;;
		4) break;;
		*) echo "Wrong Input. Try Again!"
		esac
	done	
