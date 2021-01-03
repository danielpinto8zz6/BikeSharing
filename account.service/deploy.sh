#!/bin/sh

#kubectl apply -f postgres/00postgres-namespace.yml 
kubectl apply -f postgres/01postgres-secret.yaml    
kubectl apply -f postgres/02postgres-db-pv.yaml          
kubectl apply -f postgres/03postgres-db-deployment.yaml
kubectl apply -f postgres/04pgadmin.yaml
kubectl apply -f deployment.yaml
