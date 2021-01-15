#!/bin/sh

BASEDIR=$(dirname "$0")

kubectl apply -f  $BASEDIR/postgres_rental/
kubectl apply -f  $BASEDIR/deployment.yaml
