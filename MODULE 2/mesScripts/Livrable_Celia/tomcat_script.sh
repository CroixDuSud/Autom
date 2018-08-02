#!/bin/bash
###Verifier si le dossier Tomcat existe

echo "Verification du déploiement de Tomcat dans le répertoire dossiertomCat : "
if [ -d "/home/user/documents/dossierTomcat/apache-tomcat-7.0.75" ];then
		echo $? " : le dossier existe !"
	else 
		echo $? " : le dossier n'existe pas. Il va être décompressé dans le dossier dossierTomcat."
		read -p "Veuillez indiquer le chemin exact où se trouve le fichier compressé : " cheminFichierCompresse
		### se rendre dans le dossier
		cd ~
		cd $cheminFichierCompresse
		### Decompresser TomCat dans le dossier dossierTomCat
		sudo tar xzf apache-tomcat-7.0.75.tar.gz -C dossierTomcat
		if [ $? -eq 0 ];then
			echo "Fichier décompressé avec succès."
		else
			echo  "$( date ) Un probleme est survenu lors de la décompression" >> log
		fi
	
fi

###se rendre dans le bin où se trouve le startup.sh de Tomcat
echo "Lancement de TomCat en cours..."
cd ~
cd /home/user/documents/dossierTomcat/apache-tomcat-7.0.75/bin
###Faire un chmod sur startup.sh
sudo chmod +x startup.sh
###lancer startup.sh
sudo ./startup.sh
if [ $? -eq 0 ];then
	echo $? "Tomcat lancé avec succès."
		else
	echo $? "$( date ) : Un probleme est survenu lors du lancement de Tomcat." >> log
fi

###se rendre dans le dossier où se trouve jenkins (documents) => copier jenkins dans le dossier webapp de TomCat
echo "Déploiement de Jenkins : "
cd ~
cd /home/user/documents
sudo cp -rv jenkins45.war ./dossierTomcat/apache-tomcat-7.0.75/webapps
if [ $? -eq 0 ];then
			echo $? "Installation terminée."
		else
			echo  $? "$( date ) : Un probleme est survenu lors du déploiement de Jenkins." >> log
fi

