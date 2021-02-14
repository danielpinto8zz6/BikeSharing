package estg.mtsd.bikeshare.feedback.service.vo;

import lombok.Data;

@Data
public class FeedbackVo {

	private Integer id;

	private String userEmail;

	private Integer rentalId;

	private String message;

	private Integer rating;

}