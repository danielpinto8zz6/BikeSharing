package estg.mtsd.bikeshare.rental.service.producers;

import estg.mtsd.bikeshare.shared.library.vo.UnlockBikeEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UnlockBikeEventProducer {
    @Value("${topic.unlock-bike.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(UnlockBikeEvent event) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(event));

        log.info("Adding dock event to queue!");
    }
}
