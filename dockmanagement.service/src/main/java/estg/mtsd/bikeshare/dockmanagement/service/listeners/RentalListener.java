package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.dockmanagement.service.producers.DockEventProducer;
import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockEvent;
import estg.mtsd.bikeshare.shared.library.vo.DockEvent.DockEventEnum;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RentalListener {
    @Autowired
    DockService dockService;

    @Autowired
    DockEventProducer dockEventProducer;

    @Value("${topic.rental.consumer")
    private String topicName;

    @KafkaListener(topics = "${topic.rental.consumer}", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        RentalVo rental = JsonUtils.fromJson(payload.value(), RentalVo.class);

        DockVo dock = dockService.get(rental.getDockId());
        if (dock != null) {
            dock.setBikeId(null);

            dockService.update(dock);

            // Unlock bike
            DockEvent dockEvent = new DockEvent(dock.getBikeId(), dock.getId(), DockEventEnum.UNLOCK_BIKE);
            dockEventProducer.send(dockEvent);
        }
    }
}
