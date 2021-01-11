package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentVo {

    private Integer id;

    private Integer rentalId;

    private Double value;

    private Boolean isPaid;

    private Integer method;

    private Date timestamp;

    private Integer userId;

}