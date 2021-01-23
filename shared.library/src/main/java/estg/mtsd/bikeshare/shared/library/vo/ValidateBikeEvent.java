package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ValidateBikeEvent extends BikeShareEvent {

    private String bikeCode;

    public ValidateBikeEvent(String userEmail, Integer bikeId, Integer dockId, String bikeCode) {
        this.setUserEmail(userEmail);
        this.setBikeId(bikeId);
        this.setDockId(dockId);
        this.setBikeCode(bikeCode);
        this.setTimestamp(new Date());
    }
}
