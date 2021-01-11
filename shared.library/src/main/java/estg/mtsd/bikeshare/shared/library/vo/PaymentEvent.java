package estg.mtsd.bikeshare.shared.library.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentEvent {

    public enum PaymentStatus {
        PAYMENT_SUCCEED,
        PAYMENT_FAILED
    }

    public Integer id;

    public PaymentStatus status;

}
