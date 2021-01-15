#!/bin/sh

kubectl apply -f $BASEDIR/postgres_feedback/
kubectl apply -f $BASEDIR/deployment.yaml
