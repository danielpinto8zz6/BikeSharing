package estg.mtsd.bikeshare.travel.history.receiver.service.producers;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TravelEventProducer {

    @Value("${travel-event.producer}")
    private String topicName;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(TravelEventVo travelEventVo) {
        String travelEventJson = gson.toJson(travelEventVo);

        kafkaTemplate.send(topicName, travelEventJson);

        log.info("Payload sent!");
    }
}
