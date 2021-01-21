package estg.mtsd.bikeshare.rental.process.service.listeners;

import estg.mtsd.bikeshare.rental.process.service.producers.RentalProducer;
import estg.mtsd.bikeshare.rental.process.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.BikeInsertedEvent;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BikeInsertedEventListener {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalProducer rentalProducer;

    @KafkaListener(topics = "${topic.bike-inserted.consumer}", groupId = "rental-process")
    public void consume(ConsumerRecord<String, String> payload) {

        BikeInsertedEvent event = JsonUtils.fromJson(payload.value(), BikeInsertedEvent.class);
        RentalVo rentalVo = rentalService.getByBikeId(event.getBikeId());
        if (rentalVo != null) {
            rentalVo.setEndDate(event.getTimestamp());

            rentalService.update(rentalVo);

            // Generate payment
            rentalProducer.send(rentalVo);
        }
    }
}
