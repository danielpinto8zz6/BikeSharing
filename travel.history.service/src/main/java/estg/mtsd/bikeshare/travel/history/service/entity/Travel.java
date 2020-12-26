package estg.mtsd.bikeshare.travel.history.service.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

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