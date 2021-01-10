package estg.mtsd.bikeshare.shared.library.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RentalVo {

	private Integer id;

	private Integer dockId;

	private Integer bikeId;

	private Integer userId;

	private Date startDate;

	private Date endDate;

}