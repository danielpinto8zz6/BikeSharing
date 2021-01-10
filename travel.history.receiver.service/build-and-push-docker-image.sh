#!/bin/sh

mvn clean install -Dmaven.test.skip package
docker build -t registry.gitlab.com/danielpinto8zz6/bikeshare/travel-history-receiver-service .
docker push registry.gitlab.com/danielpinto8zz6/bikeshare/travel-history-receiver-service