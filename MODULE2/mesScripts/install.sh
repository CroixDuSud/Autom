#!/bin/sh

# Script d'installation de Jenkins
sourceFolder="/home/~"
tomcatArchive="apache-tomcat-7.0.75.tar.gz"
tomcatFolder="apache-tomcat-7.0.75"
tomcatTargetPath="/opt/tomcat"
jenkinsFile="jenkins45.war"
jenkinsTargetPath="/opt/tomcat/webapps/jenkins45.war"

# Fonction de messages d'erreur
error_handler(){
	echo "$1" 1>&2
	exit 1
}

cleanLogs(){
	cd $sourceFolder && rm -f install_log.txt
}

install_JRE(){
	echo "Installation du JRE..."
	sudo apt-get update
	yes | sudo apt-get install default-jre
	# sudo apt-get install -y default-jre
	return 1
}

install_tomcat(){
	echo "verification de l'installation de tomcat..."
	if [[ -e $tomcatTargetPath ]]; then echo "tomcat détecté"
	else echo "installation de tomcat..."
		cd $sourceFolder || error_handler "Le dossier des fichiers sources n'existe pas !"
		tar -zxvf $tomcatArchive || error_handler "Impossible de décompresser le fichier !"
		mv $tomcatFolder $tomcatTargetPath || error_handler "Impossible de déplacer le ficher !"
	fi
	return 2
}

install_jenkins(){
	echo "verification de l'installation de jenkins..."
	if [[ -e $jenkinsTargetPath ]]; then echo "jenkins détecté"
	else echo "installation de jenkins..."
		cd $sourceFolder || error_handler "Le dossier des fichiers sources n'existe pas !"
		mv $jenkinsFile $jenkinsTargetPath || error_handler "Impossible de déplacer le ficher !"
	fi
	return 3
}

cleanLogs
install_JRE >> install_log.txt
echo "etape $? terminée"
install_tomcat >> install_log.txt
echo "etape $? terminée"
install_jenkins >> install_log.txt
echo "etape $? terminée"

