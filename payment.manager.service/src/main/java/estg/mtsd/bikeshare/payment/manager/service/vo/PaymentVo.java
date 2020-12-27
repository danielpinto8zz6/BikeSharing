package estg.mtsd.bikeshare.payment.manager.service.vo;

import lombok.Data;

@Data
public class PaymentVo {

	private Integer id ;

	private Double value ;

	private Boolean isPaid ;

	private Integer travelId ;

	private Integer paymentMethod ;

	private String paymentDate ;

	public PaymentVo(){
		super();
	}

}