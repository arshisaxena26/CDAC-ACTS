#   Q1.Write a program to find sum and product of two no.s using 
#            b)expr


#!/bin/bash

echo "Enter two numbers:"
read a
read b

sum=`expr $a + $b`
prod=`expr $a \* $b`

echo "Sum:$sum"
echo "Product:$prod"


