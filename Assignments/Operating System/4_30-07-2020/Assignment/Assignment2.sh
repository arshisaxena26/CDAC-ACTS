#   Q2. Write a program to perform floating point division

#!/bin/bash

echo "Enter two numbers"
read a
read b

div=`echo "scale=1; $a / $b" | bc`
echo $div
