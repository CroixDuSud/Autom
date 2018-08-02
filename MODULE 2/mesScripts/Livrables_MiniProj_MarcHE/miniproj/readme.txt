Ce dont vous avez besoin : 
apache-tomcat-7.0.75.tar.gz
jenkins45.war
jenkins_deploy.sh

Lancer le script avec la commande 
sudo sh jenkins_deploy.sh (si le script est dans le dossier courant, sinon ajouter le chemin)
Pour vérifier que tomcat s'est bien lancer, utiliser la commande 
ps aux | grep tomcat

Récupérer l'ip de votre machine avec la commande :
ipconfig
Lancer votre navigateur puis mettre l'url suivante : 
http://ipdevotremachine:8080/jenkins45


