#  Q6. Write a shell script to print all files name and size greater than 10K

#!/bin/bash

find . -type f -size +10k -ls | awk '{print $11,$7}'
