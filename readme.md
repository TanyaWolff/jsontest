# jsontest
## exploring json objects with java
tested with openjdk version 17.0.2 on mac

- download gson.2.8.9.jar from https://search.maven.org/artifact/com.google.code.gson/gson/2.8.9/jar
- export CLASSPATH=$CLASSPATH:gson-2.8.9.jar
- javac -cp $CLASSPATH pkg/*.java
- java -cp $CLASSPATH pkg/Demo

## exploring jdbc connection
tested with postgresql 9.5.4.0 and apache DBUtils 1.7

- setup pg database as in db/setup.sh
- set env vars APACHE_HOME and CLASSPATH as in db/setup.sh
- javac -cp $CLASSPATH db/Userdb.java
- java -cp $CLASSPATH db/Userdb
