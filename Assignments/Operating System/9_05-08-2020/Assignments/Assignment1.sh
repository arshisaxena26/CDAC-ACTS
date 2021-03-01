#   Q1. Do the following operation using command:
#        a. Start browser
#        b. Find pid of browser
#        c. Kill the browser process with 9 signal

#!/bin/bash

echo "------------STARTING BROWSER------------"
sensible-browser

pid=`pidof chrome`
echo "PID of BROWSER: $pid"

echo "-----------KILLING BROWSER-------------"
kill -9 $pid
