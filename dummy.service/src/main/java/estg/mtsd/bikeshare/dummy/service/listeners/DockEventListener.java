package estg.mtsd.bikeshare.dummy.service.listeners;

import estg.mtsd.bikeshare.shared.library.vo.DockEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DockEventListener {

    @Value("${topic.dock-event.consumer")
    private String topicName;

    @KafkaListener(topics = "${topic.dock-event.consumer}", groupId = "dummy")
    public void consume(ConsumerRecord<String, DockEvent> event) {
        if (event.value().getEvent() == DockEvent.DockEventEnum.UNLOCK_BIKE) {
            System.out.println("Unlocking bike...");
        }
    }
}
