#!/bin/bash

# Variables 
File_log="$home/result_final.log" 
File_erreur="$home/erreurs_final.log"

# Vérifier que le serveur Tomcat existe, sinon le déployer sur le serveur 

# fonction qui interroge la variable $? 
return_code(){
$?
if [ $? -eq 0 ]
	then 
		echo "La commande est en succès"
else 
	echo "La commande est en echec" 
fi
}

# Vérification de l'existance ou non de l'application Tomcat et la déployer
cd /usr/share && ls -l | grep tomcat >> $File_log
if [ $? -eq 0 ]
		then 
			echo "L'application Tomcat est déja déployé dans le serveur" >> $File_log
else 
			echo "L'application Tomcat n'est pas installé"  >> $File_log
			sudo mv $home/apache-tomcat-7.0.75 /usr/share/apache-tomcat >> $File_log
fi

# Vérification de l'exitance ou non de l'application Jenkins et la déployer dans le webapps de Tomcat 
cd /usr/share/apache-tomcat/webapps && ls -l | grep jenkins45 >> $File_log

if [ $? -eq 0 ]
		then 
			echo "L'application Jenkins est déja déployé dans le webapps de Tomcat" >> $File_log
else 
			echo "L'application Jenkins n'est pas déployé"  >> $File_log
			sudo mv $home/jenkins45.war /usr/share/apache-tomcat/webapps/jenkins45.war
fi

# Lancement du serveur Tomcat
cd /usr/share/apache-tomcat/bin && ./startup.sh >> $File_log
if [ $? -eq 0 ] 
	then 
		echo "Le serveur Tomcat est bien lancé" >> $File_log
else 
		echo "Le serveur Tomcat n'est pas lancé" >> $File_log
fi 


# Gestion des données en sortie  
echo "Le serveur Tomcat est bien lancé" >> $File_log
echo "L'application Jenkins est bien lancé" >> $File_log

# Gestion des erreurs dans un fichier de log
2>> $File_erreur 

