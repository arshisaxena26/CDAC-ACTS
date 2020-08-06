#  Q4. Write a shell script to print all files permissions in current directory(Not name or other details)(Use cut commands)

#!/bin/bash

ls -l ./ | sed '1d' | cut -d " " -f1


