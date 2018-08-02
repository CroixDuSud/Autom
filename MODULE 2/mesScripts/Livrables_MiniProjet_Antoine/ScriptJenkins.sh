########################################
#                                      #
# Type : Mini-projet déploiement       #
#                                      #
# Créateur : Antoine Bianchi-Bourgeois #
#                                      #
########################################

#!/bin/bash

#               ,,))))))));,
#            __)))))))))))))),
# \|/       -\(((((''''((((((((.
# -*-==//////((''  .     `)))))),
# /|\      ))| o    ;-.    '(((((                                  ,(,
#          ( `|    /  )    ;))))'                               ,_))^;(~
#             |   |   |   ,))((((_     _____------~~~-.        %,;(;(>';'~
#             o_);   ;    )))(((` ~---~  `::           \      %%~~)(v;(`('~
#                   ;    ''''````         `:       `:::|\,__,%%    );`'; ~
#                  |   _                )     /      `:|`----'     `-'
#            ______/\/~    |                 /        /
#          /~;;.____/;;'  /          ___--,-(   `;;;/
#         / //  _;______;'------~~~~~    /;;/\    /#
#        //  | |                        / ;   \;;,#\
#       (<_  | ;                      /',/-----'  #_>
#        \_| ||_                     //~;~~~~~~~~#~
#            `\_|                   (,~~ 
#                                    \~#\
#                                     ~#~######

# Variables
nom_fichier="apache-tomcat-7.0.75"		# Nom du fichier de l'archive
nom_archive=${nom_fichier}".tar.gz"		# Nom de l'archive

# Début du script

# Création des fonctions

# Fonction permettant d'inscrire un fichier log
logs(){
	tee -a $HOME/logs_script_Tomcat_Jenkins.txt
}

# Initialisation des logs

echo "------------------------------------------------------------" >> $HOME/logs_script_Tomcat_Jenkins.txt
echo "Initialisation des logs du script d'installation et de lancement Tomcat & Jenkins." >> $HOME/logs_script_Tomcat_Jenkins.txt
echo "Le tout supervisé par une licorne !" >> $HOME/logs_script_Tomcat_Jenkins.txt
echo "" >> $HOME/logs_script_Tomcat_Jenkins.txt

# Décompression de l'archive

if [ -e $HOME/$nom_archive ] && [ -e $HOME/jenkins45.war ]
	then
		if [ -d $HOME/$nom_fichier ] 	# Vérification archive
			then 
				echo "Le dossier décompressé existe déjà." | logs
		else
			# Décompression de l'archive et organisation du dossier
			tar xvf $nom_archive && echo "Le dossier $nom_fichier n'existait pas et a été créé." | logs	|| echo "Erreur : Problème lors de la décompression du fichier." | logs
		fi

		# Installation Tomcat

		if [ -d /usr/share/tomcat ] 	# Vérification dossier tomcat
			then 
				echo "Le dossier tomcat existe déjà." | logs
		else
			# Déplacement du fichier décompressé vers /usr/share
			sudo mv $nom_fichier /usr/share/tomcat && echo "Le dossier tomcat n'existait pas et a été créé." | logs || echo "Erreur : Problème lors du déplacement du fichier" | logs
		fi

		if [ -e /usr/share/tomcat/webapps/jenkins45.war ] 	# Vérification dossier tomcat
			then 
				echo "Le fichier jenkins45.war existe." | logs
		else
			# Copie du .war dans le dossier webapps de Tomcat
			sudo cp jenkins45.war /usr/share/tomcat/webapps && echo "Le fichier jenkins45.war n'existait pas et a été copié." | logs || echo "Erreur : Problème lors de la copie du fichier jenkins45.war" | logs
		fi

		cd /usr/share/tomcat/bin 						# Déplacement vers le dossier installé
		./startup.sh && echo "Lancement de Tomcat effectué." | logs || echo "Erreur : Problème lors du lancement du Tomcat." | logs
		cd												# Retour au home de l'utilisateur

		echo ""
		echo "Script terminé."
		echo "Merci de vérifier que Jenkins est correctement lancé."
		echo "Ouvrez un navigateur et aller à l'adresse suivante : {adresse_serveur}:8080/jenkins45"
		echo "Changer le port si vous avez modifié le paramétrage de Tomcat."
		echo "Fin de l'exécution du script." | logs
		echo "" >> $HOME/logs_script_Tomcat_Jenkins.txt
else
	echo "Erreur : Les fichiers requis pour l'exécution du script ne sont pas présent." | logs
	echo "" >> $HOME/logs_script_Tomcat_Jenkins.txt
fi
