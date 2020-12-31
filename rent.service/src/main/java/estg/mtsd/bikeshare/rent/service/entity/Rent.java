package estg.mtsd.bikeshare.rent.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rent")
public class Rent {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="dockId")
	private Integer dockId ;

	@Column(name="bikeId")
	private Integer bikeId ;

	@Column(name="date")
	private String date ;

	@Column(name="status")
	private Integer status ;

	public Rent(){
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