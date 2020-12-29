package estg.mtsd.bikeshare.dockmanagement.service.vo;

import lombok.Data;

@Data
public class DockVo {

	private Integer id ;

	private Long latitude ;

	private Long longitude ;

	private String location ;

	private Integer bikeId ;
}