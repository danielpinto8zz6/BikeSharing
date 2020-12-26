package estg.mtsd.bikeshare.travel.history.service.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TravelVo {

	private Integer id;

	private Date startDate;

	private Date endDate;

	private String gps;

	private String bike;
}