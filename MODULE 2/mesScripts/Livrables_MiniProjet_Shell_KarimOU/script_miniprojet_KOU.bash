#!/bin/bash

echo "Lancement de la procédure d'installation de Apache Tomcat 7.0.75 et de Jenkins45"

nom_de_l_archive="apache-tomcat-7.0.75.tar.gz"
nom_du_war="jenkins45.war"
nom_de_l_archive_decompressee="apache-tomcat-7.0.75"
nom_utilisateur_tomcat="tomcat_user"

if [[ -e $HOME/$nom_de_l_archive ]] && [[ -e $HOME/$nom_du_war ]]
then sudo apt-get --assume -yes update && sudo apt-get --assume -yes install default-jdk
echo "Le package apt-get a été mis à jour, et le Kit de Développement Java a été installé"
else echo "Les conditions nécessaires au lancement de ce script ne sont pas réunies. Veuillez vérifier les prérequis s'il vous plaît" && exit
fi

if [[ -e $HOME/$nom_de_l_archive ]] && [[ -e $HOME/$nom_du_war ]]
then tar -v -xzf $nom_de_l_archive
echo "L'archive $nom_de_l_archive a été décompressée"
else echo "L'archive $nom_de_l_archive n'est pas présente dans le dossier, de même que le war $nom_du_war. Cela fait partie des pré-requis. Veuillez disposer ces éléments dans le dossier concerné, merci." && exit
fi

if [[ $? -gt 0 ]]
then echo "L'archive $nom_de_l_archive n'est pas présente dans le dossier, de même que le war $nom_du_war. Cela fait partie des pré-requis. Veuillez disposer ces éléments dans le dossier concerné, merci." >> $HOME/log_erreur_miniprojet.txt
else echo "Le script va passer à l'étape suivante : Déplacer l'archive dans le dossier tomcat"
fi

if [[ -e $HOME/$nom_de_l_archive_decompressee ]]
then sudo mv $nom_de_l_archive_decompressee /usr/share/tomcat
echo "L'archive décompressée $nom_de_l_archive_decompressee a été déplacée à l'emplacement /usr/share/tomcat"
else echo "L'archive décompressée $nom_de_l_archive_decompressee n'est pas présente. Veuillez vérifier votre manipulation s'il vous plaît, ainsi que les pré-requis" && exit
fi

if [[ $? -gt 0 ]]
then echo "L'archive décompressée $nom_de_l_archive_decompressee n'est pas présente. Veuillez vérifier votre manipulation s'il vous plaît, ainsi que les pré-requis" >> $HOME/log_erreur_miniprojet.txt
else echo "Le script va passer à l'étape suivante : Déplacer l'archive jenkins dans le dossier webapps"
fi

if [[ -e $HOME/$nom_de_l_archive ]] && [[ -e $HOME/$nom_du_war ]]
then sudo mv $nom_du_war /usr/share/tomcat/webapps
echo "Le war $nom_du_war a été déplacé à l'emplacement /usr/share/tomcat/webapps"
else echo "Le war $nom_du_war n'est pas présent. Cela fait partie des prérequis. Veuillez mettre à disposition cet élément dans le dossier concerné" && exit
fi

if [[ $? -gt 0 ]]
then echo "Le war $nom_du_war n'est pas présent. Cela fait partie des prérequis. Veuillez mettre à disposition cet élément dans le dossier concerné" >> $HOME/log_erreur_miniprojet.txt
else echo "Le script va passer à l'étape suivante : Lancer Tomcat et vérifier qu'il a été lancé correctement"
fi

#if [[ -e $HOME/$nom_de_l_archive ]]
#then sudo useradd $nom_utilisateur_tomcat && sudo chown $nom_utilisateur_tomcat /usr/share/tomcat && sudo chmod u+rwx /usr/share/tomcat
#echo "L'utilisateur $nom_utilisateur_tomcat a été créé avec succés et tous les droits lui ont été donné sur le tomcat $nom_de_l_archive_decompressee"
#else echo "L'utilisateur $nom_utilisateur_tomcat n'a pas été créé avec succés. Veuillez vérifier votre manipulation" && exit
#fi

if [[ -e $HOME/$nom_de_l_archive ]]
then cd /usr/share/tomcat/bin && ./startup.sh
ps aux | grep tomcat
echo "Le tomcat $nom_de_l_archive_decompressee a été lancé"
else echo "Impossible de lancer le tomcat $nom_de_l_archive_decompressee. Veuillez vérifier votre manipulation" && exit
fi
