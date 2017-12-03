#!/bin/bash

username = 'somaname'
SCRIPT1="netstat -tuple | grep -e $2 -e $3 | awk '{print $6}'"
SCRIPT2="var=netstat -tuple | grep $2"
SCRIPT3="var=netstat -tuple | grep $3"

ssh -l $username $1 "${SCRIPT1}"

var1=$(ssh -l $username $1 "${SCRIPT2}")
var2=$(ssh -l $username $1 "${SCRIPT3}")

if ["$var1" == ""] && ["$var2" == ""]; then
	echo "$1 has no port"
fi

if ["$var1" != ""] && ["$var2" != ""]; then
	echo "$1 has both ports"
fi