package estg.mtsd.bikeshare.feedback.service.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "rentalId")
	private Integer rentalId;

	@Column(name = "message")
	private String message;

	@Column(name = "rating")
	private Integer rating;

}