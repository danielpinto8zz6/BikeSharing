package estg.mtsd.bikeshare.rent.service.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RentVo {

	private Integer id;

	private Integer dockId;

	private Integer bikeId;

	private Integer userId;

	private Date date;

	private Integer status;

}