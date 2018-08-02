#!/bin/bash
#################################################################################
#Créateur:									#
#									 	#
# Guillaume GARDERE							 	#
#									 	#
#################################################################################
#Script:								 	#
#										#
#Devinette des trois nains allant à la mine					#
#										#
#################################################################################

# Variables
#variable d'attente
time=1
#fonctions
question(){
echo "C est trois nains qui vont à la mine"
sleep $time
        echo "Le premier prend la pelle"
sleep $time
        echo "le second prend la pioche"
sleep $time
        echo "Que prend le troisème?"
        read answer
}

nyan_cat(){
while [ $answer =! "nyan_cat" ]; do

echo "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"
echo "░░░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░░"
echo "░░░░░░░░▄▀░░░░░░░░░░░░▄░░░░░░░▀▄░░░░░░░"
echo "░░░░░░░░█░░▄░░░░▄░░░░░░░░░░░░░░█░░░░░░░"
echo "░░░░░░░░█░░░░░░░░░░░░▄█▄▄░░▄░░░█░▄▄▄░░░"
echo "░▄▄▄▄▄░░█░░░░░░▀░░░░▀█░░▀▄░░░░░█▀▀░██░░"
echo "░██▄▀██▄█░░░▄░░░░░░░██░░░░▀▀▀▀▀░░░░██░░"
echo "░░▀██▄▀██░░░░░░░░▀░██▀░░░░░░░░░░░░░▀██░"
echo "░░░░▀████░▀░░░░▄░░░██░░░▄█░░░░▄░▄█░░██░"
echo "░░░░░░░▀█░░░░▄░░░░░██░░░░▄░░░▄░░▄░░░██░"
echo "░░░░░░░▄█▄░░░░░░░░░░░▀▄░░▀▀▀▀▀▀▀▀░░▄▀░░"
echo "░░░░░░█▀▀█████████▀▀▀▀████████████▀░░░░"
echo "░░░░░░████▀░░███▀░░░░░░▀███░░▀██▀░░░░░░"
echo "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"
sleep 10
done

}


# Script

question



while [[ -z $answer || $answer != "la tête" && $answer != "la tete" ]]; do
	
	case $answer in
		'42')
			echo "La réponse à l'univers mais ce n'est pas ca";;
		'')
                        echo "Le néant n'est pas la solution!"&& sleep $time && echo "Let's retry it! ;o)" && sleep $time;;
			
		*)
			echo "Nop essaye encore";;
       esac

question


done

echo "Well done, good job ;o)"

