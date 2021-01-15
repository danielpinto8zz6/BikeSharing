#!/bin/sh

kubectl apply -f $BASEDIR/postgres_rental/
kubectl apply -f $BASEDIR/deployment.yaml
