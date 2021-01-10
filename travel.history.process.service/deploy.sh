#!/bin/sh

kubectl apply -f deployment.yaml
kubectl apply -f mongo/01mongodb-travel-history-secret.yml
kubectl apply -f mongo/02mongo-travel-history-pv.yml
kubectl apply -f mongo/03mongo-travel-history-deployment.yml
kubectl apply -f mongo/04mongo-express.yml