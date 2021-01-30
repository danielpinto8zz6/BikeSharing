#!/bin/bash

start=`date +%s`

echo 'deploying to k8s...'

./eureka.server/deploy.sh
sleep 1m

./zuul.server/deploy.sh
sleep 1m

./token.manager/deploy.sh
sleep 1m

./account.service/deploy.sh
./auth.service/deploy.sh
./bike.validator.service/deploy.sh
./bikemanagement.service/deploy.sh
./dock.service/deploy.sh
./dockmanagement.service/deploy.sh
./dummy.service/deploy.sh
./feedback.service/deploy.sh
./notifications.service/deploy.sh
./payment.calculator.service/deploy.sh
./payment.process.service/deploy.sh
./payment.service/deploy.sh
./payment.validator.service/deploy.sh
./pgadmin.service/deploy.sh
./rental.process.service/deploy.sh
./rental.service/deploy.sh
./travel.history.process.service/deploy.sh
./travel.history.receiver.service/deploy.sh
./travel.history.service/deploy.sh

end=`date +%s`

runtime=$((end-start))

echo $runtime
