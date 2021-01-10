package estg.mtsd.bikeshare.rental.service.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalProducer {
    @Value("${topic.rental.producer}")
    private String topicName;

    private final KafkaTemplate<String, RentalVo> kafkaTemplate;

    public void send(RentalVo rent) {
        log.info("Payload sent!");
        kafkaTemplate.send(topicName, rent);
    }
}
