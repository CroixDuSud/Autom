
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