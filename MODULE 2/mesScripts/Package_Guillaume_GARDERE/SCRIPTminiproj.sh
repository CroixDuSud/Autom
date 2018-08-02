#!/bin/sh 
#
################################################################################
#
# $Header: script1-0-0.sh 12-04-2017 13:40:00
#
################################################################################
#
# Script       : script1-0-0.sh
# Auteur       : Guillaume GARDERE
# Creation     : 12-04-2017 13:40:00
# Description  : Script shell
#                Deploiement de tomcat7.0.75 et jenkins45
#                If it's hard to write it would be hard to read
#                
#
# -------+--------+------------+------------------------------------------------
# Version|  Date  |   Auteur   | Description
# -------+--------+------------+------------------------------------------------
# 1.00.00|12-04-17|G GARDERE   | Initial release
# -------+--------+------------+------------------------------------------------
#        |        |            | 
# -------+--------+------------+------------------------------------------------
#
################################################################################

#> Variables declaration
directory="/usr/share/apache-tomcat-7.0.75"
directory2="/usr/share/apache-tomcat-7.0.75/webapps"
directory3="/usr/share/apache-tomcat-7.0.75/bin"
directory4="/usr/share"
archive1="/usr/share/apache-tomcat-7.0.75.tar.gz"
archive2="/usr/share/jenkins45.war"
archive3="/usr/share/apache-tomcat-7.0.75/webapps/jenkins45.war"
install_tomcat() {
if [ -d $directory ]
        then echo "Le repertoire $directory existe"
else
        echo "Le repertoire $directory n'exiiste pas"
        sudo tar -xzf $archive1 && echo "l'archice $archive a été correctement déompressee"
fi
}
deploy_jenkins() {
cd $directory2
if [ -e $archive3 ]
        then echo "Le l'archive $archive3 existe"
else
        echo "L'archive n'est pas présente"
        sudo mv $archive2 $directory2 && echo "L'archive $archive2 a été déplacée"
fi
}
fonction_chown() {
cd $directory4
sudo chown -R tomcat:tomcat $directory
}
start_tomcat() {
cd $directory3
sudo ./startup.sh
if [ $? -gt 0 ]
        then echo "le traitement ne s'est pas lancé correctement"
else
        echo "le traitement s'est lancé correctement"
fi
}
cd $directory4
install_tomcat
fonction_chown
deploy_jenkins
fonction_chown
start_tomcat
