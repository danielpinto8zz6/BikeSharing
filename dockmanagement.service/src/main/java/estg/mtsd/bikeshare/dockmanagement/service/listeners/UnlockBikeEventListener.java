package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;
import estg.mtsd.bikeshare.shared.library.vo.UnlockBikeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UnlockBikeEventListener {

    @Autowired
    DockService dockService;

    @Value("${topic.unlock-bike.consumer")
    private String topicName;

    @KafkaListener(topics = "${topic.unlock-bike.consumer", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        UnlockBikeEvent event = JsonUtils.fromJson(payload.value(), UnlockBikeEvent.class);

        DockVo dock = dockService.get(event.getDockId());
        if (dock != null) {
            dock.setBikeId(null);

            dockService.update(dock);

            // Unlock bike
            //TODO: notify dummy
        }
    }
}