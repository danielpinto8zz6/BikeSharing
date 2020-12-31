package estg.mtsd.bikeshare.dockmanagement.service.vo;

import lombok.Data;

@Data
public class DockEvent {
    public enum DockEventEnum {
        BIKE_INSERTED,
        BIKE_REMOVED
    }

    private Integer bikeId;

    private Integer dockId;

    private DockEventEnum event;
}
