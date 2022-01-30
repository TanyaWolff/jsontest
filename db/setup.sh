# setup.sh 
# Create the database. This example uses postgresql
# Enter psql to create and connect to the database to run the sql below.
# psql
# > create database jsontest;
# > \c jsontest

create table users ( id serial primary key, firstname varchar ( 50 ), lastname varchar ( 50 ), email varchar ( 255 ), created_on timestamp not null ); 

# get apache commons dbutils jar
wget https://dlcdn.apache.org//commons/dbutils/binaries/commons-dbutils-1.7-bin.tar.gz
wget https://jdbc.postgresql.org/download/postgresql-42.3.1.jar
#wget https://dlcdn.apache.org//commons/dbcp/binaries/commons-dbcp2-2.9.0-bin.tar.gz
#wget https://dlcdn.apache.org//commons/pool/binaries/commons-pool2-2.11.1-bin.tar.gz
#wget https://dlcdn.apache.org//commons/logging/binaries/commons-logging-1.2-bin.tar.gz

# unzip to /Library/Apache and set env vars
sudo mkdir -p /Library/Apache
sudo tar xzf commons-dbutils-1.7-bin.tar.gz -C /Library/Apache
export APACHE_HOME=/Library/Apache
export CLASSPATH=$CLASSPATH:$APACHE_HOME/commons-dbutils-1.7/commons-dbutils-1.7.jar:`pwd`/postgresql-42.3.1.jar
