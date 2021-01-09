package estg.mtsd.bikeshare.travel.history.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("travel")
public class Travel {

	@Id
	private Integer id;

	private Date startDate;

	private Date endDate;

	private Integer	bikeId;

}