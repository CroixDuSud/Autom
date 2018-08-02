#!/bin/sh

# ------ Script d'installation de Jenkins -------
sourceFolder=$HOME
tomcatArchive="apache-tomcat-7.0.75.tar.gz"
tomcatFolder="apache-tomcat-7.0.75"
tomcatTargetPath="/opt/tomcat"
jenkinsFile="jenkins45.war"
jenkinsTargetPath="/opt/tomcat/webapps/jenkins45.war"

# Fonction de messages d'erreur
error_handler(){
	echo "$1" 1>&2
	#exit 1
}

# Suppression des logs
cleanLogs(){
	if [ -e $sourceFolder ]; then rm -f install_log.txt
	else
	error_handler "Le répertoire $HOME est introuvable !"
	fi
}

# Ajout de la date
adddate(){
	echo "Time: $(date)"
}

#Installation du JRE
install_JRE(){
	echo "Installation du JRE..."
	sudo apt-get update
	yes | sudo apt-get install default-jre
	# sudo apt-get install -y default-jre
}

# Installation de Tomcat
install_tomcat(){
	echo "verification de l'installation de tomcat..."
	if [ -e $tomcatTargetPath ]; then echo "tomcat détecté"
	else echo "installation de tomcat..."
		if [ -e $sourceFolder ]
			then
			tar -zxvf $tomcatArchive || error_handler "Impossible de décompresser le fichier tomcat !"
			sudo mv $tomcatFolder $tomcatTargetPath || error_handler "Impossible de déplacer le ficher tomcat!"
		else error_handler "Le répertoire $HOME est introuvable !"
		fi
	fi
}

# Installation de Jenkins
install_jenkins(){
	echo "verification de l'installation de jenkins..."
	if [ -e $jenkinsTargetPath ]; then echo "jenkins détecté"
	else echo "installation de jenkins..."
		sudo mv $jenkinsFile $jenkinsTargetPath || error_handler "Impossible de déplacer le ficher jenkins !"
	fi
}

# Démarrage de Tomcat
start_tomcat(){
	echo "démarrage de tomcat..."
	cd /opt/tomcat/bin; sudo ./startup.sh
}

# Lancement de la procédure
cleanLogs
adddate | tee -a install_log.txt
install_JRE | tee -a install_log.txt
install_tomcat | tee -a install_log.txt
install_jenkins | tee -a install_log.txt
start_tomcat | tee -a install_log.txt

