package estg.mtsd.bikeshare.bikemanagement.service.vo;

public class BikeVo {

	private Integer id ;

	private Integer chargeLevel ;

	private Long serviceHours ;

	private String serialNumber ;

	private String brand ;

	private String model ;

	public BikeVo(){
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