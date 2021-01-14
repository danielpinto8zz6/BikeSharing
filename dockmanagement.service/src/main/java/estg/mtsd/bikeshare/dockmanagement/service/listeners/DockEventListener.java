package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockEvent;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;
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
public class DockEventListener {

    @Autowired
    DockService dockService;

    @Value("${topic.dock-event.consumer")
    private String topicName;

    @KafkaListener(topics = "${topic.dock-event.consumer}", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        DockEvent event = JsonUtils.fromJson(payload.value(), DockEvent.class);

        DockVo dock;
        switch (event.getEvent()) {
            case BIKE_INSERTED:
                dock = dockService.get(event.getDockId());
                if (dock != null) {
                    if (dock.getBikeId() != null) {
                        log.error("Dock already has a bike attached!");
                    }

                    dock.setBikeId(event.getBikeId());

                    dockService.update(dock);
                }
                break;
            case BIKE_REMOVED:
                dock = dockService.get(event.getDockId());
                if (dock != null) {
                    dock.setBikeId(null);

                    dockService.update(dock);
                }
                break;
            default:
                break;
        }
    }
}
