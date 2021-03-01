#  Q4. Write a shell script that continuously print the system load and free memory(Use free command for free memory and 
#     read file /proc/loadavg for system load).Print value after 5 sec(Use sleep command)

#!/bin/bash

while [ "true" ]
	do
		echo "***********FREE MEMORY**************"
		free

		echo " "

		echo "*************SYSTEM LOAD************"
		cat /proc/loadavg

		sleep 5
	done	


