package estg.mtsd.bikeshare.payment.process.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "rental_id")
	private Integer rentalId;

	@Column(name = "value")
	private Double value;

	@Column(name = "is_paid")
	private Boolean isPaid;

	@Column(name = "method")
	private Integer method;

	@Column(name = "timestamp")
	private Date timestamp;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "name")
	private String name;

	@Column(name = "tax_number")
	private Integer taxNumber;

	@Column(name = "company")
	private String company;
}