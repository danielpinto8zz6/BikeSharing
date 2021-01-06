package estg.mtsd.bikeshare.dummy.service.listeners;

import estg.mtsd.bikeshare.shared.library.vo.DockEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DockEventListener {

    @Value("${dock-event.consumer")
    private String topicName;

    @KafkaListener(topics = "${dock-event.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, DockEvent> event) {
        if (event.value().getEvent() == DockEvent.DockEventEnum.UNLOCK_BIKE) {
            System.out.println("Unlocking bike...");
        }
    }
}
