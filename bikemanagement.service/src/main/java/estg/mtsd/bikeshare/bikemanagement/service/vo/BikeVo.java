package estg.mtsd.bikeshare.bikemanagement.service.vo;

import lombok.Data;

@Data
public class BikeVo {

	private Integer id ;

	private Integer chargeLevel ;

	private Long serviceHours ;

	private String serialNumber ;

	private String brand ;

	private String model ;

}