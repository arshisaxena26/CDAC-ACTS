# Q2. Write command to find the process in Sleep state. (1Mark)

#!/bin/bash

echo "------------Process in SLEEP State-------------------"
top -bn1 | awk 'NR > 7 && $8 ~ /S|D/ { print $12 }'

