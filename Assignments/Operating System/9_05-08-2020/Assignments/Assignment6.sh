#  Q6. Do the following operation:
#        a. Start browser
#        b. Kill process by name
#        c. Kill all Terminal window 

#!/bin/bash

echo "------STARTING BROWSER-------"
sensible-browser

sleep 5

echo "---KILLING PROCESS BY NAME---"
killall -9 chrome

echo "----KILLING ALL TERMINAL WINDOW----"
killall -9 `ps aux | grep gnome-terminal | awk '{print $11}'`
