package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

@Data
public class PaymentDataVo {
    
    private Integer paymentId;

    private String name;

    private Integer taxNumber;

    private String company;

    private Integer method;

    private String creditCardNumber;

    private String creditCardExpirationDate;

    private String creditCardCode;

    private InvoiceVo invoice;

}
