package estg.mtsd.bikeshare.bike.validator.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationProducer {
    @Value("${topic.notification.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(NotificationVo notificationVo) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(notificationVo));

        log.info("Adding notification to queue!");
    }
}
