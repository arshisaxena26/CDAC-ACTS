#  Q11. Write a menu driven file manager that lets you list,create and delete files or directories.

#!/bin/bash

while [ "true" ]
	do
		echo "******OPTIONS*******"
		echo "1. List a Directory"
		echo "2. Create File(s)"
		echo "3. Create Directories"
		echo "4. Delete Files"
		echo "5. Delete Directories"
		echo "6. Exit"

		read ch

		case $ch in

		1) 	echo -n "Enter the Name of the Directory: "
			read dirname
			ls $dirname
			echo " ";;

		2)  echo "Enter File Names,press q to stop"
			while read fname && [[ "$fname" != q ]]
				do
					touch $fname
				done 
				echo " ";;	

		3)  echo "Enter Directory Names,press q to stop"
			while read dname && [[ "$dname" != q ]]
				do
					mkdir $dname
				done 
				echo " " ;;

		4)  echo "Enter File Names,press q to stop"
			while read fdname && [[ "$fdname" != q ]]
				do
					rm $fdname
				done
				echo " ";;

		5)  echo "Enter Directory Names,press q to stop"
			while read ddname && [[ "$ddname" != q ]]
				do
					rm -r $ddname
				done 
				echo " ";;

		6)break;;

		esac
	done
