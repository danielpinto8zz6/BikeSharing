package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import estg.mtsd.bikeshare.dockmanagement.service.producers.BikeInsertedEventProducer;
import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.BikeInsertedEvent;
import estg.mtsd.bikeshare.shared.library.vo.DockClosedEvent;
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
public class DockClosedEventListener {

    @Autowired
    private DockService dockService;

    @Autowired
    private BikeInsertedEventProducer bikeInsertedEventProducer;

    @KafkaListener(topics = "${topic.dock-closed.consumer", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {
        DockClosedEvent event = JsonUtils.fromJson(payload.value(), DockClosedEvent.class);

        DockVo dock = dockService.get(event.getDockId());
        if (dock != null) {
            if (dock.getBikeId() != null) {
                log.error("Dock already has a bike attached!");
            }

            dock.setBikeId(event.getBikeId());

            dockService.update(dock);

            bikeInsertedEventProducer.send(new BikeInsertedEvent(event.getBikeId(), event.getDockId()));
        }
    }
}