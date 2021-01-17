package estg.mtsd.bikeshare.payment.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="payment")
public class Payment {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="rental_id")
	private Integer rentalId ;

	@Column(name="value")
	private Double value ;

	@Column(name="status")
	private Integer status ;

	@Column(name="method")
	private Integer method ;

	@Column(name="timestamp")
	private Date timestamp ;

	@Column(name="user_email")
	private String userEmail ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	private Invoice invoice;

}