#  Q3. Write a script that print environment variable(Print $HOME,$PATH,$SHELL,$HISTORY,$LOGNAME,$TERM)

#!/bin/bash

env | grep ^HOME
env | grep ^PATH
env | grep ^SHELL
env | grep ^HISTORY
env | grep ^LOGNAME
env | grep ^TERM
