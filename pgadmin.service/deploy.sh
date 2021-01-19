#!/bin/sh

BASEDIR=$(dirname "$0")

kubectl apply -f  $BASEDIR/01pgadmin-secret.yaml
kubectl apply -f  $BASEDIR/02pgadmin.yaml
