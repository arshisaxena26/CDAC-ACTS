#   Q1.Write a menu based script to perform following string operations
#          a) To find length of a string
#          b) Copying string
#          c) Concatenation of strings
#          d) Comparison of two strings
#          e) Reversing a string

#!/bin/bash

while [ "true" ]
	do
		echo "************Options*************"
		echo "1. Length of the String"
		echo "2. Copy String"
		echo "3. Concatenate Strings"
		echo "4. Compare Strings"
		echo "5. Reverse String"
		echo "6. Exit"

		read choice
		
		case $choice in
		1) echo -n "Enter the String: "
			read string
			echo "Length:${#string}";;
		2)echo "Enter two Strings"
			read string1
			newString=$string1
			echo "String 1:$string1"
			echo "String 2:$newString";;
		3)echo "Enter two Strings"
			read string1
			read string2
			string3=$string1$string2
			echo "Concatenated String:$string3";;
		4)echo "Enter two Strings"
			read string1
			read string2
			if [ $string1 != $string2 ]
				then
				echo "Strings are not equal"
			else
				echo "Strings are equal"
			fi;;
		5)echo "Enter a String"
			read str
			echo -n "Reverse: "
			echo $str | rev;;
		6)break;;
		*)echo "Wrong Input. Try again!";;
		esac
			
	done	

