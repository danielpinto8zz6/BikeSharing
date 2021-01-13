#!/bin/sh

mvn clean install -Dmaven.test.skip
docker build -t registry.gitlab.com/danielpinto8zz6/bikeshare/rental-process-service .
docker push registry.gitlab.com/danielpinto8zz6/bikeshare/rental-process-service