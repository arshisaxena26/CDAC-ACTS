# Q3. Write a program to print calendar of current month in next year,previous years.For eg:-sep 2014,sep 2012 if current month is sep 2013

#!/bin/bash

month=`date +%m`
year=`date +%Y`

prev=$(($year - 1))
next=$(($year + 1))

cal -d $prev-$month
cal -d $next-$month
