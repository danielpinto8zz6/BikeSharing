package estg.mtsd.bikeshare.rental.service.producers;

import estg.mtsd.bikeshare.shared.library.vo.UnlockBikeEvent;
import estg.mtsd.bikeshare.shared.library.vo.ValidateBikeEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidateBikeEventProducer {
    @Value("${topic.validate-bike.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(ValidateBikeEvent event) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(event));

        log.info("Adding validate bike event to queue!");
    }
}
