package estg.mtsd.bikeshare.payment.calculator.service.producers;

import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentRequestProducer {
    @Value("${topic.payment-request.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(PaymentRequestVo paymentRequestVo) {
        kafkaTemplate.send(topicName, JsonUtils.toJson(paymentRequestVo));

        log.info("Adding payment request to queue!");
    }
}
