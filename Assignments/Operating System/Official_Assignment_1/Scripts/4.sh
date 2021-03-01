# Q4. Create a script that asks for uid of a user and displays group name of that user along with # 	other members(if any) of that group.

#!/bin/bash

echo "Enter UID"
read uid

uname=`getent passwd "$uid"|cut -d: -f1`

if [ $uname ]
then	
	members=`grep ^$uname /etc/group | cut -d ":" -f 4`

	if [ $members ]
	then
#		echo $members
		echo "Members of the Group-$uname are: $members"
	else
		echo "No members found for Group-$uname"
	fi	
else
	echo "UID not Found"
fi



