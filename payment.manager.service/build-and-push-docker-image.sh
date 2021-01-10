#!/bin/sh

docker build -t registry.gitlab.com/danielpinto8zz6/bikeshare/payment-service .
docker push registry.gitlab.com/danielpinto8zz6/bikeshare/payment-service