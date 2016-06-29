# oracledb-api

Dependinte:
oracle database 12c
-su oracle
-$ORACLE_HOME/bin/lsnrctl start
-sqlplus
-user-name: sys as sysdba
-password: systempass????
-startup;
-exit;
-sqlplus
-username ? 
-password ?....

ojdbc7.jar ( se gaseste in oracledb-api/
java 1.8



Merg butoanele:
1. Connect to a databse specific schema ( dupa ce se introduc inputurle : hostname, port,user, password, databes name.

2.Execute ( accepta doar queryuri momentan nu este implementata si optiunea sa citeasca din fisier si sa execute "script")

Afisarea se face in textfieldul din dreapta.


Descriere:

Clasa ApplicationController - preia inputuri, proceseaza trigerele de la butoane ( click ).

Clasa InputDevice ete un intermediar intre ApplicationController si DBConnection ( pentru viitoare updateuri ).

Clasa AppEngine - executa queriuri ( 	Statement stmt = stmt definit in dbconnection) .

momentan afisarea o face ApplicationController ( pentru viitor ar fi ok sa adaug un OutputDevice sa se ocupe de treaba asta )




