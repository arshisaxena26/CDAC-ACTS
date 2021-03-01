#  Q5. Write a menu driven file manager shell script(Create function for each operation.Use infinite loop):
#			a) Create file
#			b)Create directory
#			c)Delete file
#			d)Delete directory
#			e)List content of current directory
#			f)change directory
#			g)cat file content
#			h)add content to a file


#!/bin/bash

CreateF()
{
	echo -n "Enter File Name: "
	read fname

	if [ -f $fname ]
	then
		echo "File Already Exits"
		echo " "
	else	
		touch $fname
		echo "File $fname successfuly created"
		echo " "
	fi	
	}

CreateD()
{
	echo -n "Enter Directory Name: "
	read dname

	if [ -d $dname ]
	then
		echo "Directory already exists"
		echo " "
	else	
		mkdir $dname
		echo "Directory $dname successfully created"
		echo " "
	fi	
	}

DeleteF()
{
	echo -n "Enter File Name: "
	read fdname

	if [ -f $fdname ]
	then	
		rm $fdname
		echo "File $fdname successfully deleted"
		echo " "
	else
		echo "File $fdname doesn't exist"
		echo " "
	fi	
	}

DeleteD()
{
	echo -n "Enter Directory Name: "
	read ddname

	if [ -d $ddname ]
	then	
		rm -r $ddname
		echo "Directory $ddname successfully deleted"
		echo " "
	else
		echo "Directory doesn't exist"
		echo " "
	fi	
	}

List()
{
	echo "Listing contents of Current Directory:"
	ls ./
	echo " "
	}

ChangeD()
{
	echo -n "Enter Directory Path: "
	read dpath
	cd $dpath
	echo "You are now in `pwd` "
	echo " "
	}

View()
{
	echo -n "Enter File Name: "
	read fview
	
	if [ -f $fview ]
	then	
		cat $fview
	else
		echo "File doesn't exist"
		echo " "
	fi	
	}

Append()
{
	echo -n "Enter File Name: "
	read fapp

	if [ -f $fapp ]
	then	
		echo "Add Content to file. Press Ctrl+d to Save"
		cat >> $fapp
		echo " "
	else
		echo "File doesn't exist"
	fi	
	}

while [ "true" ]
	do
		echo "**********OPTIONS************"
		echo "1. Create a File"
		echo "2. Create a Directory"
		echo "3. Delete a File"
		echo "4. Delete a Directory"
		echo "5. List contents of Current Directory"
		echo "6. Change Directory"
		echo "7. View a File Content"
		echo "8. Add Content to a File"
		echo "9. Exit"

		read ch
		case $ch in

		1) CreateF;;
		2)CreateD;;
		3)DeleteF;;
		4)DeleteD;;
		5)List;;
		6)ChangeD;;
		7)View;;
		8)Append;;
		9)break;;
		*) echo "Wrong Input. Try Again!" ;;
		esac
	done	
