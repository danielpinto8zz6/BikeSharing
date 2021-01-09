#!/bin/bash
echo "Launching minikube..."
minikube start
echo "Launching services..."

#kubectl delete -f ./MTSDS/mongo/00mongodb-namespace.yml
#kubectl delete -f ./MTSDS/mongo/01mongodb-secret.yml
#kubectl delete -f ./MTSDS/mongo/02mongo-deployment.yml
#kubectl delete -f ./MTSDS/mongo/03mongo-configmap.yml
#kubectl delete -f ./MTSDS/mongo/04mongo-express.yml

#sleep 30

kubectl apply -f ./MTSDS/mongo/00mongodb-namespace.yml
sleep 1
kubectl apply -f ./MTSDS/mongo/01mongodb-secret.yml
sleep 1
kubectl apply -f ./MTSDS/mongo/02mongo-deployment.yml
sleep 1
kubectl apply -f ./MTSDS/mongo/03mongo-configmap.yml
sleep 1
kubectl apply -f ./MTSDS/mongo/04mongo-express.yml

sleep 30

minikube service mongoexpress-service -n mongodb-namespace
