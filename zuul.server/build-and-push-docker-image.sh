#!/bin/sh

docker build -t registry.gitlab.com/danielpinto8zz6/bikeshare/zuul-server .
docker push registry.gitlab.com/danielpinto8zz6/bikeshare/zuul-server