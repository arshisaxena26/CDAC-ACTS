#   Q2. Write a shell script to count words in the given file(pass filename as command line argument. Use wc command).
#       If file is not there create it and ask for content of file then save it.

#!/bin/bash

if [ -f $1 ]
then
	words=`wc -w $1 | cut -d " " -f1`
	echo "Total words in $1 File are: $words"
else
	echo "Creating new file $1...Write the content and press Ctrl+d to Save"
	cat > $1
	words=`wc -w $1 | cut -d " " -f1`
	echo "Total Words in $1 File are: $words"
fi	
