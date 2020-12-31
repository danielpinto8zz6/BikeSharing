package estg.mtsd.bikeshare.rent.service.vo;

public class RentVo {

	private Integer id ;

	private Integer dockId ;

	private Integer bikeId ;

	private String date ;

	private Integer status ;

	public RentVo(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getDockId(){
		return this.dockId;
	}

	public void setDockId(Integer dockId){
		this.dockId = dockId;
	}

	public Integer getBikeId(){
		return this.bikeId;
	}

	public void setBikeId(Integer bikeId){
		this.bikeId = bikeId;
	}

	public String getDate(){
		return this.date;
	}

	public void setDate(String date){
		this.date = date;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

}