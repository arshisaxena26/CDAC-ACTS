#  Q8. Write a shell script:
#		a)Download https://raw.githubusercontent.com/curran/data/gh-pages/all/geonames_cities10000000.csv using curl command
# 		b) print name if population is greater than 12691835													

#!/bin/bash

echo "--------DOWNLOADING FILE-------------"
curl -o geonames.csv https://raw.githubusercontent.com/curran/data/gh-pages/all/geonames_cities10000000.csv

echo "Cities with Population more than 12691835 are: "
awk '{FS=","} $4 > 12691835 {print $1}' geonames.csv 
