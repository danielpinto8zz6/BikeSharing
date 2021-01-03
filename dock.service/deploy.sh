#!/bin/sh

kubectl apply -f postgres/
kubectl apply -f deployment.yaml
