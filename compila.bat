@echo off

if not exist bin (
	echo  *** Criando Diretorio bin ***
	mkdir bin
)

echo  *** Compilando projeto ***
javac -cp lib/sqlite-jdbc-3.30.1.jar -sourcepath src -d bin src/*.java