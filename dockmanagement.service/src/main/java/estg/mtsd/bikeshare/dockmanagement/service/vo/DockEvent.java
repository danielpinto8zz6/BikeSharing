package estg.mtsd.bikeshare.dockmanagement.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DockEvent {
    public enum DockEventEnum {
        BIKE_INSERTED,
        BIKE_REMOVED,
        UNLOCK_BIKE
    }

    private Integer bikeId;

    private Integer dockId;

    private DockEventEnum event;
}
