package estg.mtsd.bikeshare.payment.validator.service.listeners;

import estg.mtsd.bikeshare.payment.validator.service.producers.NotificationProducer;
import estg.mtsd.bikeshare.payment.validator.service.producers.PaymentEventProducer;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.NotificationVo;
import estg.mtsd.bikeshare.shared.library.vo.PaymentEvent;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rx.Notification;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentListener {
    @Autowired
    PaymentEventProducer paymentEventProducer;

    @Autowired
    NotificationProducer notificationProducer;

    @KafkaListener(topics = "${topic.payment.consumer}", groupId = "payment-validator")
    public void consume(ConsumerRecord<String, String> payload) {
        PaymentVo payment = JsonUtils.fromJson(payload.value(), PaymentVo.class);

        if (payment != null) {
            if (payment.getName() != null) {
                paymentEventProducer
                        .send(new PaymentEvent(payment.getId(), PaymentEvent.PaymentStatus.PAYMENT_SUCCEED));
            } else {
                NotificationVo notificationVo = new NotificationVo();
                notificationVo.setEmail(payment.getUserEmail());
                notificationVo.setTitle("Payment failed!");

                notificationProducer.send(notificationVo);
            }
        }
    }
}
