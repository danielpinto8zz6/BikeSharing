package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DockClosedEvent extends BikeShareEvent {

    private String bikeCode;

    public DockClosedEvent(Integer bikeId, Integer dockId, String bikeCode) {
        this.setBikeId(bikeId);
        this.setDockId(dockId);
        this.setBikeCode(bikeCode);
        this.setTimestamp(new Date());
    }
}
