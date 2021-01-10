#!/bin/sh

kubectl apply -f postgres_account/
kubectl apply -f deployment.yaml
