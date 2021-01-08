package estg.mtsd.bikeshare.travel.history.service.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("travel")
public class Travel {

	private Integer id;

	@Id
	private ObjectId _id;

	private Date startDate;

	private Date endDate;

	private String gps;

	private String bike;
}