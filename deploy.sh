#!/bin/bash

start=`date +%s`

echo 'deploying to k8s...'

./eureka.server/deploy.sh
./zuul.server/deploy.sh
./travel.history.process.service/deploy.sh
./bikemanagement.service/deploy.sh
./dockmanagement.service/deploy.sh
./payment.calculator.service/deploy.sh
./feedback.service/deploy.sh
./payment.service/deploy.sh
./account.service/deploy.sh
./auth.service/deploy.sh
./dock.service/deploy.sh
./dummy.service/deploy.sh
./travel.history.receiver.service/deploy.sh
./rental.service/deploy.sh
./travel.history.service/deploy.sh
./rental.process.service/deploy.sh
./payment.process.service/deploy.sh
./payment.validator.service/deploy.sh
./notifications.service/deploy.sh
./token.manager/deploy.sh
./pgadmin.service/deploy.sh

end=`date +%s`

runtime=$((end-start))

echo $runtime
