package estg.mtsd.bikeshare.account.service.vo;

import lombok.Data;

@Data
public class UserVo {

	private Integer id;

	private String username;

	private String password;

	private String role;
}