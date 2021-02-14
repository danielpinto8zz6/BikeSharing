package estg.mtsd.bikeshare.dockmanagement.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.OpenDockEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDockEventProducer {
    @Value("${topic.open-dock.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(OpenDockEvent event) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(event));

        log.info("Open dock event sent!");
    }
}
