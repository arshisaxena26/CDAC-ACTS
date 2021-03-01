#   Q1.Write a program to find sum and product of two no.s using 
#                     c) bc

#!/bin/bash

echo "Enter two numbers:"
read a
read b

sum=`echo "$a + $b" | bc`
prod=`echo "$a * $b" | bc`

echo "Sum:$sum"
echo "Product:$prod"
