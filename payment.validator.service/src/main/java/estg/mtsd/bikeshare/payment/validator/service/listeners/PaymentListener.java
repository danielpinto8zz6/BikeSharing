package estg.mtsd.bikeshare.payment.validator.service.listeners;

import estg.mtsd.bikeshare.payment.validator.service.producers.PaymentEventProducer;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentEvent;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
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
public class PaymentListener {

    @Value("${topic.payment.consumer")
    private String topicName;

    @Autowired
    PaymentEventProducer paymentEventProducer;


    @KafkaListener(topics = "${topic.payment.consumer}", groupId = "payment-validator")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        PaymentVo payment = JsonUtils.fromJson(payload.value(), PaymentVo.class);

        paymentEventProducer.send(new PaymentEvent(payment.getId(), PaymentEvent.PaymentStatus.PAYMENT_SUCCEED));
    }
}
