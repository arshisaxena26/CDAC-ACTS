#   Q7. Write a script to print day of the week using
#              b) case

#!/bin/bash

d=`date`
day=`echo ${d:0:3}`

case $day in
Sun) echo "Today is Sunday";;
Mon) echo "Today is Monday";;
Tue) echo "Today is Tuesday";;
Wed) echo "Today is Wednesday";;
Thu) echo "Today is Thursday";;
Fri) echo "Today is Friday";;
*) echo "Today is Saturday";;
esac


