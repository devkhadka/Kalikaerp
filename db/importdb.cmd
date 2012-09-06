
set DBUSER="root"
set DBPASS=
set DATABASENAME="kalikalatest"
C:\xampp\mysql\bin\mysqladmin -u %DBUSER% -p%DBPASS% drop %DATABASENAME%
C:\xampp\mysql\bin\mysqladmin -u %DBUSER% -p%DBPASS% create %DATABASENAME%
C:\xampp\mysql\bin\mysql -u %DBUSER% -p%DBPASS% %DATABASENAME% < createuser.sql
C:\xampp\mysql\bin\mysql -u %DBUSER% -p%DBPASS% %DATABASENAME% < install.sql
