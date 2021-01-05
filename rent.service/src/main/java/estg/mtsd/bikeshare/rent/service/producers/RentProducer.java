package estg.mtsd.bikeshare.rent.service.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.shared.library.vo.RentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, RentVo> kafkaTemplate;

    public void send(RentVo rent) {
        log.info("Payload sent!");
        kafkaTemplate.send(topicName, rent);
    }
}
