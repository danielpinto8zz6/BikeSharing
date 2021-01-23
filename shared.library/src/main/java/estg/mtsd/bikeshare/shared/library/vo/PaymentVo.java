package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentVo {

    public static final Integer AWAITING_PAYMENT = 0;
    public static final Integer VALIDATING_PAYMENT = 1;
    public static final Integer PAID = 2;
    public static final Integer PAYMENT_FAILED = 3;

    private Integer id;

    private Integer rentalId;

    private Double value;

    private Integer status;

    private Integer method;

    private Date timestamp;

    private String userEmail;

    private String name;

    private Integer taxNumber;

    private String company;

}