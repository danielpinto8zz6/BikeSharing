#!/bin/sh

BASEDIR=$(dirname "$0")

kubectl apply -f  $BASEDIR/deployment.yaml
kubectl apply -f  $BASEDIR/mongo_travel