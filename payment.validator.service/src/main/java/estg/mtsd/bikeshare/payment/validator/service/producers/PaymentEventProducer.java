package estg.mtsd.bikeshare.payment.validator.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentEvent;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentEventProducer {

    @Value("${topic.payment-event.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(PaymentEvent paymentEventVo) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(paymentEventVo));

        log.info("Adding payment event to queue!");
    }
}
