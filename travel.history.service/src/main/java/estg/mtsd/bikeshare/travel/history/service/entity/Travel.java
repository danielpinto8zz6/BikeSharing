package estg.mtsd.bikeshare.travel.history.service.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("travel")
public class Travel {

	@Id
	private String id;

	private Date startDate;
	
	private Date endDate;

	private Integer userId;

	private Integer	bikeId;

	private Integer rentId;

}