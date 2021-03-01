#   Q10.Write a menu driven script(Use infinite loop for options.Program should ask for options continuously ):
#			a)shows ip address( use ip a)
#			b)shows free disk space (use df command)
#			c)shows free ram(use free command)
#			d)shows system info(use uname -a command)
#			e)list all files in home directory
#			f)list all files from /etc/ ends with .conf
#			g)Exit

#!/bin/bash

while [ "true" ]
	do
		echo "*****OPTIONS*****"
		echo "1. IP Address"
		echo "2. Free Disk Space"
		echo "3. Free RAM"
		echo "4. System Information"
		echo "5. Files in Home Directory"
		echo "6. All Configuration Files in /etc/"
		echo "7. Exit"

		read ch

		case $ch in

		1)	ip a
			echo " " ;;
		2) 	df -h
			echo " ";;
		3)  free -h
			echo " ";;
		4)  uname -a
			echo " ";;
		5)  ls -l ~/ | grep ^-
			echo " ";;
		6)  cd /etc/
			ls *.conf
			echo " ";;
		7)	break;;
		*)  echo "Wrong Input. Try Again!";;

		esac

	done

