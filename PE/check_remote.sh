#!/bin/bash

SCRIPT = "ps -ef -o pcpu -p $1 | grep -v CPU"
for i in 'cat allhosts' 
do
	ssh $i "${SCRIPT}" &
done