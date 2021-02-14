package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

@Data
public class NotificationVo {

    private String title;

    private String body;

    private String email;

    private PaymentVo paymentVo;

}