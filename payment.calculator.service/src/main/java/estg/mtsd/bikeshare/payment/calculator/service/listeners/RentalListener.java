package estg.mtsd.bikeshare.payment.calculator.service.listeners;

import estg.mtsd.bikeshare.payment.calculator.service.producers.PaymentRequestProducer;
import estg.mtsd.bikeshare.payment.calculator.service.service.PaymentCalculatorService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentRequestVo;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
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
public class RentalListener {

    @Value("${topic.rental.consumer")
    private String topicName;

    @Autowired
    private PaymentCalculatorService paymentCalculatorService;

    @Autowired
    private PaymentRequestProducer paymentRequestProducer;

    @KafkaListener(topics = "${topic.rental.consumer}", groupId = "payment-calculator")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: " + topicName);
        log.info("key: " + payload.key());
        log.info("Headers: " + payload.headers());
        log.info("Partion: " + payload.partition());
        log.info("Order: " + payload.value());

        RentalVo rentalVo = JsonUtils.fromJson(payload.value(), RentalVo.class);

        double value = paymentCalculatorService.calculate(rentalVo.getStartDate(), rentalVo.getEndDate());

        PaymentRequestVo paymentRequestVo = new PaymentRequestVo(rentalVo.getStartDate(), rentalVo.getEndDate(), rentalVo.getId(), rentalVo.getUserId(), value);

        paymentRequestProducer.send(paymentRequestVo);
    }
}
