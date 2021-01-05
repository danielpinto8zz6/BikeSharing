package estg.mtsd.bikeshare.shared.library.vo;

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