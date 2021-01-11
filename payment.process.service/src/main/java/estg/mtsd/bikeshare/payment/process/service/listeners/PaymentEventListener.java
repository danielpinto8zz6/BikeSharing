package estg.mtsd.bikeshare.payment.process.service.listeners;

import estg.mtsd.bikeshare.payment.process.service.service.PaymentService;
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
public class PaymentEventListener {

    @Value("${topic.payment-event.consumer")
    private String topicName;

    @Autowired
    PaymentService paymentService;

    @KafkaListener(topics = "${topic.payment-event.consumer}", groupId = "payment-process")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        PaymentEvent paymentEvent = JsonUtils.fromJson(payload.value(), PaymentEvent.class);

        PaymentVo paymentVo = paymentService.get(paymentEvent.getId());
        if (paymentVo != null) {
            switch (paymentEvent.getStatus()) {
                case PAYMENT_SUCCEED:
                    paymentVo.setStatus(PaymentVo.PAID);
                    break;
                case PAYMENT_FAILED:
                default:
                    paymentVo.setStatus(PaymentVo.PAYMENT_FAILED);
                    break;
            }

            paymentService.update(paymentVo);
        }

        // TODO: Notify user
    }
}
