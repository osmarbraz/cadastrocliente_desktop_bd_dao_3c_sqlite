@echo off

if exist bin (
	echo  *** Executando projeto ***
	java -cp lib/sqlite-jdbc-3.30.1.jar;bin Principal
)