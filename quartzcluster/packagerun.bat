@echo off
set "CURRENT_DIR=%cd%"
call mvn clean package
copy /y target\QuartzCluster.war D:\software\learning\apache-tomcat-7.0.65\webapps
rd /q /s D:\software\learning\apache-tomcat-7.0.65\webapps\QuartzCluster
cd /D D:\software\learning\apache-tomcat-7.0.65\bin
echo current directory: %cd%
rem call D:\software\learning\apache-tomcat-7.0.65\bin\shutdown.bat
call D:\software\learning\apache-tomcat-7.0.65\bin\startup.bat
cd /D "%CURRENT_DIR%"
rem pause