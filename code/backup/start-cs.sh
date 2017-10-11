#!/usr/bin/expect -f

set username "root"
set password "root_password"
set timeout 10
set startpath "/mnt/local/apps/tomcat/portal_manage/startup-cs.sh"

spawn su - $username -s $startpath
expect {
    "*Password:" { send "$password\r" }
}
interact
