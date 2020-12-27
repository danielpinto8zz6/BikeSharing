package estg.mtsd.bikeshare.shared.library.models;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentRequest {

    private int id;

    private Date startDate;

    private Date endDate;

    private String username;

}
