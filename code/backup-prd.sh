#!/bin/sh

APP_NAME=manage.jar
APP_PATH=/mnt/local/tomcat8/portal_manage
BACKUP_PATH=../backup

backup(){
	cd $APP_PATH
	if [ ! -f "$APP_NAME" ]; then
		rm -rf $APP_NAME
		rm -rf nohup.out
	else
		cp $APP_NAME $BACKUP_PATH
		rm -rf $APP_NAME
		rm -rf nohup.out
	fi
}

backup
