#  Q6. Write a system monitor script to print load average of cpu(Use /proc/loadavg file.
#      Print value continuously every 3 second)(If you want to replace current line value you can use the following syntax
#                      echo -ne `command`\\r\\n . 
#      Here \r carriage return will move cursor back and -n will not let it add newline)


#!/bin/bash

while [ "true" ]
	do
		echo "****CPU LOAD AVERAGE****"
		cat /proc/loadavg
		echo -ne `sleep 3`\\r\\n
	done
