# Q3. Write a menu driven script to do following task:
#	    a) Update your repositories and write output in a file (Don’t upgrade.It might few minutes wait for that)
#	    b) Install screenfetch
#	    c) Run screenfetch
#	    d) Ask user for his favorite movies
#	    e) Store movies in file
#	    f) Search for movies from file having substring given by user 


#!/bin/bash

while [ 1 ]
	do
		echo "-----------OPTIONS----------------"
		echo "1. Update Repositories" 
		echo "2. Install screenfetch"
        echo "3. Run screenfetch"
        echo "4. List Favorite Movies"
        echo "5. Store Movies in File"
        echo "6. Search Substring in Movies File"
		echo "7.Exit"

		read ch

		case $ch in
		1)sudo apt update;;
		2)sudo apt install screenfetch;;
		3)screenfetch;;
		4)echo "List you favorite movies below. Press Ctrl+d to Stop"
			cat > mov;;
		5)echo -n "Enter File Name: "
			read name
			mv mov $name;;
		6)echo -n "Enter Substring: "
			read str
			grep $str $name;;
		7)break;;
		*)echo "Wrong Input. Try Again!"
		esac

	done	
