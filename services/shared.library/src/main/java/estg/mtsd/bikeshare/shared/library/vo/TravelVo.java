package estg.mtsd.bikeshare.shared.library.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TravelVo {

	private String id;

	private Date startDate;

	private Date endDate;

	private Integer bikeId;

	private Integer rentalId;

	private String userEmail;

	private List<TravelEventVo> gps;
	
}
