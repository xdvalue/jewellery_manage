#!/bin/sh

export JAVA_HOME=/mnt/local/java/jdk1.8.0_131
export JRE_HOME=/mnt/local/java/jdk1.8.0_131/jre

echo "JAVA_HOME="$JAVA_HOME
echo "JRE_HOME="$JRE_HOME

APP_NAME=manage.jar
APP_PORT=8680
APP_EVN=prd
APP_PATH=/mnt/local/tomcat8/portal_manage

portalPID=0  

getProtalPID(){  
    javaps=`$JAVA_HOME/bin/jps -l | grep $APP_NAME`  
    if [ -n "$javaps" ]; then  
        portalPID=`echo $javaps | awk '{print $1}'`  
    else  
        portalPID=0  
    fi  
}  
  
startup(){  
    getProtalPID  
    echo "================================================================================================================"  
    if [ $portalPID -ne 0 ]; then  
        echo "$APP_NAME already started(PID=$portalPID)"  
        echo "================================================================================================================"  
    else  
        echo -n "Starting $APP_NAME"  
        cd $APP_PATH
        nohup $JAVA_HOME/bin/java -jar $APP_NAME --spring.profiles.active=$APP_EVN --server.port=$APP_PORT >/dev/null 2>&1 &  
        getProtalPID  
        if [ $portalPID -ne 0 ]; then  
            echo "(PID=$portalPID)...[Success]"  
            echo "================================================================================================================"  
        else  
            echo "[Failed]"  
            echo "================================================================================================================"  
        fi  
    fi  
}  
  
startup
