package estg.mtsd.bikeshare.dummy.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockClosedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DockClosedEventProducer {

    @Value("${topic.dock-closed.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(DockClosedEvent event) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(event));
        log.info("Dock closed event sent!");
    }
}
