package estg.mtsd.bikeshare.dockmanagement.service.listeners;

import estg.mtsd.bikeshare.dockmanagement.service.producers.OpenDockEventProducer;
import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;
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

    @KafkaListener(topics = "${topic.unlock-bike.consumer}", groupId = "dock-management")
    public void consume(ConsumerRecord<String, String> payload) {
        UnlockBikeEvent event = JsonUtils.fromJson(payload.value(), UnlockBikeEvent.class);

        DockVo dock = dockService.get(event.getDockId());
        if (dock != null) {
            dock.setBikeId(-1);

            dockService.update(dock);

            OpenDockEvent openDockEvent = new OpenDockEvent(dock.getBikeId(), dock.getId());
            openDockEventProducer.send(openDockEvent);
        }
    }
}