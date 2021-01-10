#!/bin/sh

kubectl apply -f postgres_payment/
kubectl apply -f deployment.yaml
