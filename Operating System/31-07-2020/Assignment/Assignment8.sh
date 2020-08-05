#  Q8.Write a script to store PRN no in an array:
#    	a)Ask each student to store his/her personal info in file If his PRN does not exists in the array
#	    b)Give exit option

#!/bin/bash

prn=(001 003 005 007 009 011 013 015 017 019)

while [ "true" ]
	do
		echo "****OPTIONS******"
		echo "1. New Student Registration"
		echo "2. Exit"

		read ch

		case $ch in 
			
		1) echo -n "Enter PRN Number: "
			read num
			flag=0

			for i in "${prn[@]}"
				do
					if [ $num -eq $i ]
					then
						echo "----PRN $num PRESENT----"
						echo " "
						flag=1
						break
					fi	
				done	
			
			if [ $flag -eq 0  ]
			then
				echo "New Student Registration"
				echo "Enter your Name and Course [Ctrl+d to save]"
				cat > Student.txt
				prn+=($num)
			fi ;;

		2) break;;
		esac
	done	


