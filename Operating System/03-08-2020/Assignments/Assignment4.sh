#  Q4. Write a shell script to print all files permissions in current directory(Not name or other details)(Use cut commands)

#!/bin/bash

ls -l ./ | cut -d " " -f1


