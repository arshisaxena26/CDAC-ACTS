# Q1. Write a menu driven shell script: (2Marks)
#		a) Find process id of process given by user(User should give the process name)
#		b) Kill the process using -9 signal.
#       c) Execute date command with strace. Find the statement where bash is creating child process

#!/bin/bash

echo -n "Enter Process Name: "
read pname

while [ 1 ]
	do
		echo "----------OPTIONS----------"
		echo "1. Find PID"
		echo "2. Kill Process"
		echo "3. Find Child Process"
		echo "4. EXIT"

		read ch

		case $ch in

		1)pid=`pidof $pname`
			if [ $pid ]
			then
				echo -n "PID of $pname: $pid"
			else
				echo "Process $pname NOT Found."
			fi	
			echo -e "\n";;

		2)killall -9 $pname;;

		3)strace -f date;;  #check

		4)break;;

		*)echo "Wrong Input. Try Again!"
		
		esac
	done	

