# Q5. b) To find avg of 3 no.s, read no.s from keyboard

#!/bin/bash

echo "Enter three numbers"
read a
read b
read c

avg=$((($a+$b+$c)/3))
echo "Average:$avg"
