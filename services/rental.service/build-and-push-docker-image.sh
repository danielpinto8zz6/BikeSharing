#!/bin/sh

BASEDIR=$(dirname "$0")

mvn -f $BASEDIR clean install -Dmaven.test.skip 
docker build -t registry.gitlab.com/danielpinto8zz6/bikeshare/rental-service $BASEDIR
docker push registry.gitlab.com/danielpinto8zz6/bikeshare/rental-service
