#!/bin/bash

start=`date +%s`

echo 'building and pushing services/docker images...'

./shared.library/build.sh
./account.service/build-and-push-docker-image.sh
./auth.service/build-and-push-docker-image.sh
./bike.validator.service/build-and-push-docker-image.sh
./bikemanagement.service/build-and-push-docker-image.sh
./dock.service/build-and-push-docker-image.sh
./dockmanagement.service/build-and-push-docker-image.sh
./dummy.service/build-and-push-docker-image.sh
./eureka.server/build-and-push-docker-image.sh
./feedback.service/build-and-push-docker-image.sh
./notifications.service/build-and-push-docker-image.sh
./payment.calculator.service/build-and-push-docker-image.sh
./payment.process.service/build-and-push-docker-image.sh
./payment.service/build-and-push-docker-image.sh
./payment.validator.service/build-and-push-docker-image.sh
./rental.process.service/build-and-push-docker-image.sh
./rental.service/build-and-push-docker-image.sh
./token.manager/build-and-push-docker-image.sh
./travel.history.process.service/build-and-push-docker-image.sh
./travel.history.receiver.service/build-and-push-docker-image.sh
./travel.history.service/build-and-push-docker-image.sh
./zuul.server/build-and-push-docker-image.sh

end=`date +%s`

runtime=$((end-start))

echo $runtime
