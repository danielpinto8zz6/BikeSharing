#!/bin/sh

kubectl apply -f $BASEDIR/postgres_bike/
kubectl apply -f $BASEDIR/deployment.yaml