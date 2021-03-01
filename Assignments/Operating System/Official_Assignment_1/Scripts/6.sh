#  Q6. Create a script that asks for interface name and displays IP address for that interface.

#!/bin/bash
	
	echo -n “Enter Interface Name: ”
	read nf
	
	ip addr show $nf
