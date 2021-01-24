package estg.mtsd.bikeshare.bike.validator.service.listeners;

import estg.mtsd.bikeshare.bike.validator.service.producers.NotificationProducer;
import estg.mtsd.bikeshare.bike.validator.service.producers.UnlockBikeEventProducer;
import estg.mtsd.bikeshare.bike.validator.service.service.BikeService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.BikeVo;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;
import estg.mtsd.bikeshare.shared.library.vo.UnlockBikeEvent;
import estg.mtsd.bikeshare.shared.library.vo.ValidateBikeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ValidateBikeEventListener {

    @Autowired
    BikeService bikeService;

    @Autowired
    UnlockBikeEventProducer unlockBikeEventProducer;

    @Autowired
    NotificationProducer notificationProducer;

    @KafkaListener(topics = "${topic.validate-bike.consumer}", groupId = "travel-history-process")
    public void consume(ConsumerRecord<String, String> payload) {
        ValidateBikeEvent event = JsonUtils.fromJson(payload.value(), ValidateBikeEvent.class);

        if (event != null) {
            BikeVo bikeVo = bikeService.get(event.getBikeId());
            if (bikeVo != null && bikeVo.getCode().equals(event.getBikeCode())) {

                UnlockBikeEvent unlockBikeEvent = new UnlockBikeEvent(event.getBikeId(), event.getDockId());
                unlockBikeEventProducer.send(unlockBikeEvent);

                return;
            }

            NotificationVo notificationVo = new NotificationVo();
            notificationVo.setEmail(event.getUserEmail());
            notificationVo.setTitle("Failed to validate bike code!");

            notificationProducer.send(notificationVo);
        }
    }
}
