package estg.mtsd.bikeshare.travel.history.service.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("travel_event")
public class TravelEvent {

    private int travelId;

    private double latitude;

    private double longitude;

    private Date timestamp;
    
}
