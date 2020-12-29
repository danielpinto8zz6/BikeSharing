package estg.mtsd.bikeshare.dockmanagement.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dock")
public class Dock {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="latitude")
	private Long latitude ;

	@Column(name="longitude")
	private Long longitude ;

	@Column(name="location")
	private String location ;

	@Column(name="bikeId")
	private Integer bikeId ;

}