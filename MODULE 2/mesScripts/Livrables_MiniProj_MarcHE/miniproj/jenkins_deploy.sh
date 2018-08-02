#!/bin/bash
#exec > >(tee -i tomlog.txt)
#exec 2>&1
RED='\033[0;31m'
NC='\033[0m'
echo "${RED}Install of JAVA${NC}" | tee -a tomlog.txt
apt-get --assume-yes install openjdk-8-jdk
#echo "${RED}Set JAVA_HOME${NC}"
#export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
#chown -R tomcat:tomcat /usr/share/tomcat
echo "${RED}Verify if tomcat is installed in /usr/share/tomcat${NC}"
if ! [ -e /usr/share/tomcat ]
then
    echo Tomcat is not installed | tee tomlog.txt
    echo "Write the path of your tomcat/jenkins (example : /home/tomcat)"
    read -r path
    if [ -e ${path}/apache-tomcat-7.0.75.tar.gz ] || [ -e ${path}/jenkins45.war ]
    then
	tar -xzf ${path}/apache-tomcat-7.0.75.tar.gz
	echo "${RED}Copy tomcat in /usr/share/tomcat${NC}" | tee -a tomlog.txt
	cp -r ${path}/apache-tomcat-7.0.75 /usr/share/tomcat
	#read -r path2
	echo "${RED}Copy jenkins in /usr/share/tomcat/webapps${NC}" | tee -a tomlog.txt
	cp ${path}/jenkins45.war /usr/share/tomcat/webapps/.
	#/usr/share/tomcat/bin/startup.sh
    else
	echo "Tomcat/Jenkins are not in this folder" | tee -a tomlog.txt
	echo "Exiting" | tee -a tomlog.txt
	exit
    fi
else
    if ! [ -e /usr/share/tomcat/webapps/jenkins45.war ]
    then
	echo Jenkins is not installed | tee -a tomlog.txt
	echo "Write the path of your jenkins (example : /home/tomcat)"
	read -r path
	echo "${RED}Copy jenkins in /usr/share/tomcat/webapps${NC}" | tee -a tomlog.txt
	if ! [ -e ${path}/jenkins45.war ]
	then
	echo "Jenkins is not in this folder" | tee -a tomlog.txt
	echo "Exiting" | tee -a tomlog.txt
	exit
	fi
	cp ${path}/jenkins45.war /usr/share/tomcat/webapps/.
    fi
fi
	echo "${RED}Exec of tomcat${NC}" | tee -a tomlog.txt
      cd  /usr/share/tomcat/bin && ./startup.sh

    
