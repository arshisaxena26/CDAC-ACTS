#  Q7. Write a script to print day of the week using
#               a) elif

#!/bin/bash

d=`date`
day=`echo ${d:0:3}`

if [ $day = Sun ]
then
	echo "Today is Sunday"
elif [ $day = Mon ]
then 
	echo "Today is Monday"
elif [ $day = Tue ]
then
	echo "Today is Tuesday"
elif [ $day = Wed ]
then
	echo "Today is Wednesday"
elif [ $day = Thu ]
then
	echo "Today is Thursday"
elif [ $day = Fri ]
then
	echo "Today is Friday"
else
	echo "Today is Saturday"
fi
	
