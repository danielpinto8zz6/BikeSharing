package estg.mtsd.bikeshare.notifications.service.vo;

import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import lombok.Data;

@Data
public class NotificationVo {

    private String title;

    private String body;

    private String token;

    private String email;

    private PaymentVo paymentVo;

}