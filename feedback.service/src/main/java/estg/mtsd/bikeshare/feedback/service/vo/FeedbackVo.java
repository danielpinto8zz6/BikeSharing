package estg.mtsd.bikeshare.feedback.service.vo;

public class FeedbackVo {

	private Integer id ;

	private Integer userId ;

	private Integer travelId ;

	private String message ;

	private Integer rating ;

	public FeedbackVo(){
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