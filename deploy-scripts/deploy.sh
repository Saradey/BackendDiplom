#!/usr/bin/env bash

mvn clean package

echo 'Copy file'

scp /Users/evgenygoncharov/Desktop/program/Spring/program2/diplomNew/target/diplom-0.0.1-SNAPSHOT.jar root@46.173.218.84:/usr/project/

echo 'Restart server'

ssh root@46.173.218.84 pgrep java | xargs kill -9

echo 'end deploy'