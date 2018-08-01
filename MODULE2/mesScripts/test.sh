#!/bin/sh

#function
test() {
	echo "Hello World $1"
	if [ $1 -eq 1 ]
		return $1
	else
		return 0
	fi
}

test 1
test 0

ret=$?

echo "valeur $ret"

