package estg.mtsd.bikeshare.payment.process.service.listeners;

import estg.mtsd.bikeshare.payment.process.service.service.PaymentService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentRequestVo;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentRequestListener {

    @Value("${topic.payment-request.consumer")
    private String topicName;

    @Autowired
    PaymentService paymentService;

    @KafkaListener(topics = "${topic.payment-request.consumer}", groupId = "payment-process")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        PaymentRequestVo paymentRequestVo = JsonUtils.fromJson(payload.value(), PaymentRequestVo.class);

        PaymentVo paymentVo = new PaymentVo();
        paymentVo.setStatus(PaymentVo.AWAITING_PAYMENT);
        paymentVo.setTimestamp(new Date());
        paymentVo.setRentalId(paymentRequestVo.getRentalId());
        paymentVo.setValue(paymentRequestVo.getValue());
        paymentVo.setUserEmail(paymentRequestVo.getUserEmail());

        paymentService.save(paymentVo);

        // TODO: Notify user
    }
}
