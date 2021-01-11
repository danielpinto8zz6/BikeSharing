package estg.mtsd.bikeshare.shared.library.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequestVo {

    private Date startDate;

    private Date endDate;

    private Integer rentalId;

    private Integer userId;

    private Double value;

}
