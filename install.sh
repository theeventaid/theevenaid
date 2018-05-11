#!/bin/sh

set -e

cp $SITE_DIR/application.properties src/main/resources/application.properties

echo '[Install] Cleaning Project...'
./mvnw clean

echo '[Install] Packaging Project...'
./mvnw package

echo '[Install] Moving WAR...'
mv target/eventaid-0.0.1-SNAPSHOT.war $WAR_TARGET_LOCATION
