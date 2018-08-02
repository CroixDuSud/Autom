#!/bin/sh

tomcatArchive="apache-tomcat-7.0.75.tar.gz"
tomcatFolder="apache-tomcat-7.0.75"
tomcatTargetPath="/opt/tomcat"
jenkinsFile="jenkins45.war"
jenkinsTargetPath="/opt/tomcat/webapps/jenkins45.war"

install_JRE(){
	echo "Installation du JRE..."
	sudo apt-get update
	yes | sudo apt-get install default-jre
	# sudo apt-get install -y default-jre
}

install_tomcat(){
	echo "verification de l'installation de tomcat..."
	if [[ -e $tomcatTargetPath ]]; then
		echo "tomcat détecté"
	else echo "installation de tomcat..."; cd /home; tar -zxvf 
	fi
}

install_jenkins(){
	echo "verification de l'installation de jenkins..."
	if [[ -e $jenkinsTargetPath ]]; then
		echo "jenkins détecté"
	else echo "installation de jenkins..."; cd /home; mv $jenkinsFile $jenkinsTargetPath
	fi
}

test() {
	echo " verification presence $1"
	if [ -e $1 ]
		r=1
	else
		r=0
	fi
	return r
}

test $tomcatFolder
ret1=$?
test $jenkinsFile
ret2=$?

if [ $ret1 -eq 1 ]
echo "tomcat existe deja !"
mv apache-tomcat-7.0.75 /opt/tomcat
else
echo "installation de tomcat..."
cd /home
tar -zxvf apache-tomcat-7.0.75.tar.gz
mv apache-tomcat-7.0.75 /opt/tomcat
fi

if [ $ret2 -eq 1 ]
echo "jenkins exite deja !"
mv jenkins45.war /opt/tomcat/webapps
else
echo "installation de jenkins..."
mv jenkins45.war /opt/tomcat/webapps/jenkins45.war
fi
