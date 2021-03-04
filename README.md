### Services

| Service  |  Port |
| ------------ | ------------ |
| account-service  | 8100  |
| auth-service  | 8200  |
| bike-management-service  | 8800  |
| dock-service  | 9400  |
| dock-management-service  | 8900  |
| feedback-service  | 8300  |
| payment-calculator-service  | 9000  |
| payment-service  | 8400  |
| rental-service  | 8500  |
| travel-history-service  | 8600  |
| travel-history-process-service  | 8700  |
| payment-pro   cess-service  | 9100  |
| dummy-service  | 9200  |
| travel-history-receiver-service  | 9300  |
| rental-process-service  | 9500  |
| payment-validator-service  | 9600  |
| token-manager  | 9700  |
| token-manager  | 9700  |
| notification-service  | 9800  |
| bike-validator-service  | 9900  |
| zuul-server  | 9090  |
| eureka-server  | 8761  ||

### Build and push services
Each service has a `build-and-push-docker-image.sh` script which is responsible for building the service and respective docker image and deploy it to our gitlab container registry.

### Deploy services
Each service has a `deploy.sh` service which is responsable for deploying the previous deployed docker image in kubernetes according to the service configurations specificed in deployment.yaml.

### Build and deploy everything one shot
There's a script called `deploy.sh` in the root of services folder, which will build all services and docker images, deploy all docker images to gitlab container registry and deploy the micro-services, databases and services to kubernetes.


------------

*More detailed information about how to configure access to kubernetes or our vagrant box can be found on reports folder, in `report.pdf`*
