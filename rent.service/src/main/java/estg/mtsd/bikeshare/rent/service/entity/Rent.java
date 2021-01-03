package estg.mtsd.bikeshare.rent.service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "rent")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "dock_id")
	private Integer dockId;

	@Column(name = "bike_id")
	private Integer bikeId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "create_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "status")
	private Integer status;

	@PrePersist
	protected void onCreate() {
		date = new Date();
	}

}