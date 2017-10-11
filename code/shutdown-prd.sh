#!/bin/sh

export JAVA_HOME=/mnt/local/java/jdk1.8.0_131
export JRE_HOME=/mnt/local/java/jdk1.8.0_131/jre

echo "JAVA_HOME="$JAVA_HOME
echo "JRE_HOME="$JRE_HOME

APP_NAME=manage.jar

portalPID=0

getProtalPID(){
    javaps=`$JAVA_HOME/bin/jps -l | grep $APP_NAME`
    if [ -n "$javaps" ]; then
        portalPID=`echo $javaps | awk '{print $1}'`
    else
        portalPID=0
    fi
}

shutdown(){  
    getProtalPID  
    echo "================================================================================================================"  
    if [ $portalPID -ne 0 ]; then  
        echo -n "Stopping $APP_NAME(PID=$portalPID)..."  
        kill -9 $portalPID  
        if [ $? -eq 0 ]; then  
            echo "[Success]"  
            echo "================================================================================================================"  
        else  
            echo "[Failed]"  
            echo "================================================================================================================"  
        fi  
        getProtalPID  
        if [[ $portalPID -ne 0 ]]; 
        then  
            shutdown  
        fi  
    else  
        echo "$APP_NAME is not running"  
        echo "================================================================================================================"  
    fi  
}  

shutdown
