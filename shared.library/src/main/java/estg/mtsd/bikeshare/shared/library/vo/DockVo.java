package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

@Data
public class DockVo {

    private Integer id;

    private Long latitude;

    private Long longitude;

    private String location;

    private Integer bikeId;
    
}
