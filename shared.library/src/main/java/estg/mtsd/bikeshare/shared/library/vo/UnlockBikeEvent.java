package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnlockBikeEvent extends BikeShareEvent {
    public UnlockBikeEvent(Integer bikeId, Integer dockId) {
        this.setBikeId(bikeId);
        this.setDockId(dockId);
        this.setTimestamp(new Date());
    }
}
