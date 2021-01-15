#!/bin/sh

kubectl apply -f $BASEDIR/deployment.yaml
kubectl apply -f $BASEDIR/mongo_travel