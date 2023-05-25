#!/bin/bash
for i in $(seq "$1");
do
	echo "========================================"
	echo "itération $i"
	java RegistryViewer localhost 1099
	echo "========================================"	
	sleep 1
done
exit 0
