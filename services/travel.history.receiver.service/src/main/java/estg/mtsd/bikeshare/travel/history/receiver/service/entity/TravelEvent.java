package estg.mtsd.bikeshare.travel.history.receiver.service.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TravelEvent {

    private int travelId;

    private double latitude;

    private double longitude;

    private Date timestamp;
    
}
