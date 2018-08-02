#!/bin/bash

echo " "
echo " "
echo "@@  @@  @@"
echo "@@  @@  @@"
echo "@@@@@@  @@"
echo "@@@@@@  @@"
echo "@@  @@  @@"
echo "@@  @@  @@"
echo " "
echo " "

sleep 2

sudo apt-get update
sudo apt-get --assume-yes install git
sudo apt-get --assume-yes install default-jre

username=$(whoami)

sudo rm errors.txt 2> /dev/null
sudo rm -rf miniproject 2>> errors.txt
mkdir miniproject 2>> errors.txt
cd miniproject

git clone https://github.com/cleitus/unix_mini_project.git 2>> errors.txt
cd unix_mini_project

lines=$(find /home/$username -xdev 2>/dev/null -name "apache-tomcat-7.0.75" | wc -l)
if [ $lines -eq 0 ]; then
	gunzip apache-tomcat-7.0.75.tar.gz
	tar xvf apache-tomcat-7.0.75.tar
fi

tomcat=$(find /home/$username -xdev 2>/dev/null -name "apache-tomcat-7.0.75")
cd $tomcat

mv $(find /home/$username -name "jenkins45.war") $tomcat/webapps 2>> errors.txt

cd $tomcat/bin

./startup.sh
sleep 5
./shutdown.sh
sleep 3
./startup.sh

echo " "
echo " "
echo "BITCH  @@  @@ BITCH  @@"
echo "@@  @@  @  @  @@     @@"
echo "BITCH    @@   BITCH  @@"
echo "@@  @@   @    @@       "
echo "BITCH   @     BITCH  @@"
echo " "
echo " "