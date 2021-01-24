package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import estg.mtsd.bikeshare.dockmanagement.service.producers.NotificationProducer;
import estg.mtsd.bikeshare.dockmanagement.service.producers.OpenDockEventProducer;
import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;
import estg.mtsd.bikeshare.shared.library.vo.OpenDockEvent;
import estg.mtsd.bikeshare.shared.library.vo.UnlockBikeEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UnlockBikeEventListener {

    @Autowired
    DockService dockService;

    @Autowired
    OpenDockEventProducer openDockEventProducer;

    @Autowired
    NotificationProducer notificationProducer;

    @KafkaListener(topics = "${topic.unlock-bike.consumer}", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {

        UnlockBikeEvent event = JsonUtils.fromJson(payload.value(), UnlockBikeEvent.class);

        if (event != null) {
            DockVo dock = dockService.get(event.getDockId());
            if (dock != null) {
                Integer dockId = dock.getId();
                Integer bikeId = dock.getBikeId();

                dock.setBikeId(null);

                dockService.update(dock);

                OpenDockEvent openDockEvent = new OpenDockEvent(bikeId, dockId);
                openDockEventProducer.send(openDockEvent);

                NotificationVo notificationVo = new NotificationVo();
                notificationVo.setEmail(event.getUserEmail());
                notificationVo.setTitle("Enjoy your ride!");

                notificationProducer.send(notificationVo);
            }
        }
    }
}