package estg.mtsd.bikeshare.dockmanagement.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.BikeInsertedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BikeInsertedEventProducer {
    @Value("${topic.bike-inserted.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(BikeInsertedEvent event) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(event));

        log.info("Open dock event sent!");
    }
}
