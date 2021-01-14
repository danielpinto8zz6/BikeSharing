package estg.mtsd.bikeshare.rental.process.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rental")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "dock_id")
	private Integer dockId;

	@Column(name = "bike_id")
	private Integer bikeId;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@PrePersist
	protected void onCreate() {
		startDate = new Date();
	}

}