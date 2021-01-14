package estg.mtsd.bikeshare.feedback.service.vo;

import lombok.Data;

@Data
public class FeedbackVo {

	private Integer id;

	private Integer userEmail;

	private Integer travelId;

	private String message;

	private Integer rating;

}