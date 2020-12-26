package estg.mtsd.bikeshare.auth.service.security;

import lombok.Data;

@Data
public class UserVo {

	private Integer id;

	private String username;

	private String password;

	private String role;
}