package estg.mtsd.bikeshare.payment.manager.service.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentRequest {

   private Date startDate;
   
   private Date endDate;

   private int travelId;
   
}
