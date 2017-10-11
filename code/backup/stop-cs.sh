#!/usr/bin/expect -f

set username "root"
set password "root_password"
set timeout 10
set shutdownpath "/mnt/local/apps/tomcat/portal_manage/shutdown-cs.sh"

spawn su - $username -s $shutdownpath
expect {
    "*Password:" { send "$password\r" }
}
interact
