#!/bin/sh

kubectl apply -f $BASEDIR/postgres_account/
kubectl apply -f $BASEDIR/deployment.yaml
