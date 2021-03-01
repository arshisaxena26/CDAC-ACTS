#  Q5. Write a shell script to print all files permissions and name of file

#!/bin/bash

ls -l ./ | sed '1d' | awk '{print $1,$9}'
