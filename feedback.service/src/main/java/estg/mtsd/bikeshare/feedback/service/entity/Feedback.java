package estg.mtsd.bikeshare.feedback.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="userId")
	private Integer userId ;

	@Column(name="travelId")
	private Integer travelId ;

	@Column(name="message")
	private String message ;

	@Column(name="rating")
	private Integer rating ;

	public Feedback(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getTravelId(){
		return this.travelId;
	}

	public void setTravelId(Integer travelId){
		this.travelId = travelId;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public Integer getRating(){
		return this.rating;
	}

	public void setRating(Integer rating){
		this.rating = rating;
	}

}