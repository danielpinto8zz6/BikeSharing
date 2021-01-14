package estg.mtsd.bikeshare.rental.process.service.listeners;

import estg.mtsd.bikeshare.rental.process.service.producers.RentalProducer;
import estg.mtsd.bikeshare.rental.process.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockEvent;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DockEventListener {

    @Value("${topic.dock-event.consumer")
    private String topicName;

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalProducer rentalProducer;

    @KafkaListener(topics = "${topic.dock-event.consumer}", groupId = "rental-process")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        DockEvent dockEvent = JsonUtils.fromJson(payload.value(), DockEvent.class);
        if (dockEvent.getEvent() == DockEvent.DockEventEnum.BIKE_INSERTED) {
            RentalVo rentalVo = rentalService.getByBikeId(dockEvent.getBikeId());
            if (rentalVo != null) {
                rentalVo.setEndDate(dockEvent.getTimestamp());

                rentalService.update(rentalVo);

                // Generate payment
                rentalProducer.send(rentalVo);
            }
        }
    }
}
