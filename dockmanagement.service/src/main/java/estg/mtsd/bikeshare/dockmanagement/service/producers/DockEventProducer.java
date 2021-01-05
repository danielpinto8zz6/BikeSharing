package estg.mtsd.bikeshare.dockmanagement.service.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.dockmanagement.service.vo.DockEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DockEventProducer {
    @Value("${dock-event.producer}")
    private String topicName;

    private final KafkaTemplate<String, DockEvent> kafkaTemplate;

    public void send(DockEvent event) {
        log.info("Event sent!");
        kafkaTemplate.send(topicName, event);
    }
}
