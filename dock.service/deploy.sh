#!/bin/sh

kubectl apply -f postgres_dock/
kubectl apply -f deployment.yaml
