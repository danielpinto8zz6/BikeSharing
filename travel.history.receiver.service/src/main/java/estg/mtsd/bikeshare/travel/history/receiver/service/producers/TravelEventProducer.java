package estg.mtsd.bikeshare.travel.history.service.producers;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TravelEventProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, TravelEventVo> kafkaTemplate;

    public void send(TravelEventVo travelEventVo) {
        log.info("Payload sent!");
        kafkaTemplate.send(topicName, travelEventVo);
    }
}
