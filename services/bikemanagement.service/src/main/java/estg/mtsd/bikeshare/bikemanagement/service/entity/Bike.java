package estg.mtsd.bikeshare.bikemanagement.service.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="bike")
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id ;

	@Column(name="charge_level")
	private Integer chargeLevel ;

	@Column(name="service_hours")
	private Long serviceHours ;

	@Column(name="code")
	private String code ;

	@Column(name="brand")
	private String brand ;

	@Column(name="model")
	private String model ;

}