#  Q3. Write a menu driven script shell script that will:
#	a)print cpu information(read file /proc/cpuinfo)
#	b)print user details such as uid,gid,username,groups,home directory,default shell and his encrypted password
#		(you can use uid,gid,groups commands and print $HOME,$SHELL or try finding in /etc/passwd and /etc/shadow)

#!/bin/bash

CPU()
{
	cat /proc/cpuinfo
	echo " "

	}

User()
{
	username=`whoami`
	echo "USERNAME: $username"
	echo "UID: `id -u $username`"
	echo "GID: `id -g $username`"
	echo "GROUPS: `groups $username | cut -d ":" -f2`"
	echo "HOME DIRECTORY: $HOME"
	echo "DEFAULT SHELL: $SHELL"
	echo "ENCRYPTED PASSWORD: `sudo grep ^$username /etc/shadow | cut -d ":" -f2`"
	echo " "

	}

while [ 1 ]
	do
		echo "*****OPTIONS********"
		echo "1. CPU Information"
		echo "2. User Details"
		echo "3. Exit"

		read ch

		case $ch in 

		1)CPU;;
		2)User;;
		3)break;;
		8)echo "Wrong Input. Try Again!";;
		esac
	done	
