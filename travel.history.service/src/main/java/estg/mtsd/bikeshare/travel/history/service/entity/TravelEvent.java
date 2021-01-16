package estg.mtsd.bikeshare.travel.history.service.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("event")
public class TravelEvent {

    private int rentalId;

    private double latitude;

    private double longitude;

    private Date timestamp;
    
}
