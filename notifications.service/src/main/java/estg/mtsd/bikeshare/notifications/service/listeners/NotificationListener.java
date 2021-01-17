package estg.mtsd.bikeshare.notifications.service.listeners;

import com.google.firebase.messaging.FirebaseMessagingException;
import estg.mtsd.bikeshare.notifications.service.service.FirebaseMessagingService;
import estg.mtsd.bikeshare.notifications.service.service.TokenService;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
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
public class NotificationListener {

    @Value("${topic.notification.consumer")
    private String topicName;

    @Autowired
    FirebaseMessagingService messagingService;

    @Autowired
    TokenService tokenService;

    @KafkaListener(topics = "${topic.notification.consumer}", groupId = "notification")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        NotificationVo notificationVo = JsonUtils.fromJson(payload.value(), NotificationVo.class);

        if (notificationVo.getEmail() != null) {
            String token = tokenService.findById(notificationVo.getEmail());

            try {
                messagingService.sendNotification(notificationVo, token);
            } catch (FirebaseMessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
