#   Q5. Write a script to perform the following
#        a. To count no.of processes which are running or ready in the system (Hint:- ps -e -o pid,ppid,cmd,stat, grep ) 
#        b. List out foreground processes running in the system (ps suffix + in the state for the foreground processes)


#!/bin/bash

#ps -e -o pid | wc -w
echo "Processes Running: `ps -eo pid,user,stat,comm | wc -l`"
echo "Foreground Processes: `ps aux | grep R+ | wc -l`"
