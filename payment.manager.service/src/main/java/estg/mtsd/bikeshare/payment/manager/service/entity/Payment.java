package estg.mtsd.bikeshare.payment.manager.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="payment")
public class Payment {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="value")
	private Double value ;

	@Column(name="isPaid")
	private Boolean isPaid ;

	@Column(name="travelId")
	private Integer travelId ;

	@Column(name="paymentMethod")
	private Integer paymentMethod ;

	@Column(name="paymentDate")
	private String paymentDate ;

}