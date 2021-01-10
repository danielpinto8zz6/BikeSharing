package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DockEvent {
    public enum DockEventEnum {
        BIKE_INSERTED,
        BIKE_REMOVED,
        UNLOCK_BIKE
    }

    private Integer bikeId;

    private Integer dockId;

    private DockEventEnum event;

    private Date timestamp;

    public DockEvent(Integer bikeId, Integer dockId, DockEventEnum event) {
        this.bikeId = bikeId;
        this.dockId = dockId;
        this.event = event;
        this.timestamp = new Date();
    }
}
