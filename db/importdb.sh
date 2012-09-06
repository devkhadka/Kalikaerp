#!/bin/bash

##### 
DBUSER="root"  #user name with privileges to create db
DBPASS="" #password for the above user
DATABASENAME="kalikaerp"
#create new database named focustesting
mysqladmin -u $DBUSER -p$DBPASS drop $DATABASENAME --force
mysqladmin -u $DBUSER -p$DBPASS create $DATABASENAME
mysql -u $DBUSER -p$DBPASS $DATABASENAME < createuser.sql
mysql -u $DBUSER -p$DBPASS $DATABASENAME < install.sql
