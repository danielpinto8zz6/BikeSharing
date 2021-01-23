package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

@Data
public class BikeVo {

    private Integer id;

    private Integer chargeLevel;

    private Long serviceHours;

    private String code;

    private String brand;

    private String model;

}