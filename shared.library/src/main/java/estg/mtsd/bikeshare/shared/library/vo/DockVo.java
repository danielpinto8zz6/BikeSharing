package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

@Data
public class DockVo {

    private Integer id;

    private Double latitude;

    private Double longitude;

    private String location;

    private Integer bikeId;

}
