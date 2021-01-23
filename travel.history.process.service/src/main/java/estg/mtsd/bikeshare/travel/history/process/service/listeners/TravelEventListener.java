package estg.mtsd.bikeshare.travel.history.process.service.listeners;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.travel.history.process.service.service.TravelEventService;
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
public class TravelEventListener {

    @Autowired
    TravelEventService travelEventService;


    @KafkaListener(topics = "${topic.travel-event.consumer}", groupId = "travel-history-process")
    public void consume(ConsumerRecord<String, String> payload) {
        TravelEventVo travelEvent = JsonUtils.fromJson(payload.value(), TravelEventVo.class);

        travelEventService.save(travelEvent);
    }
}
