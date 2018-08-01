#!/bin/bash

echo "Entrez un numero de telephone"
numForm1='^\+33[0-9]{9}$'
numForm2='^0[0-9]{9}$'
read num
if [[ $num =~ $numForm1 ]] || [[ $num =~ $numForm2 ]]
then echo "Le format du numero est correct"
else echo "Le format du numero est incorrect"
fi
