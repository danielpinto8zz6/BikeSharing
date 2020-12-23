package estg.mtsd.bikeshare.bikemanagement.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike")
public class Bike {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="charge_level")
	private Integer chargeLevel ;

	@Column(name="service_hours")
	private Long serviceHours ;

	@Column(name="serial_number")
	private String serialNumber ;

	@Column(name="brand")
	private String brand ;

	@Column(name="model")
	private String model ;

	public Bike(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getChargeLevel(){
		return this.chargeLevel;
	}

	public void setChargeLevel(Integer chargeLevel){
		this.chargeLevel = chargeLevel;
	}

	public Long getServiceHours(){
		return this.serviceHours;
	}

	public void setServiceHours(Long serviceHours){
		this.serviceHours = serviceHours;
	}

	public String getSerialNumber(){
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getModel(){
		return this.model;
	}

	public void setModel(String model){
		this.model = model;
	}

}