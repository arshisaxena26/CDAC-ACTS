# Q2. Write a menu driven shell script to get system information
#	    a) Print list of PCI Cards of your pc(Use lspci commands)
#	    b) Print Logs of your pc(use dmesg command)
#	    c) Print usb devices connected to your pc(lsusb command)
#	    d) Print all files with starting with ‘sd’ name in /dev directory


#!/bin/bash

while [ 1 ]
	do
		echo "-------OPTIONS--------"
		echo "1. List of PCI Cards"
		echo "2. Logs"
		echo "3. Connected USB Devices"
		echo "4. Files starting with 'sd' in /dev"
		echo "5.Exit"

		read ch

		case $ch in
		1)lspci;;
		2)dmesg;;
		3)lsusb;;
		4)cd /dev;ls sd*;;
		5)break;;
		6)echo "Wrong Input. Try Again!"
		esac
	done	

