package estg.mtsd.bikeshare.auth.service.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser user = restTemplate.getForObject("http://localhost:8100/user/" + username, AppUser.class);
		if (user == null) {
			throw new UsernameNotFoundException("Username: " + username + " not found");
		}

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());

		// The "User" class is provided by Spring and represents a model class for user
		// to be returned by UserDetailsService
		// And used by auth manager to verify and check user authentication.
		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

	// A (temporary) class represent the user saved in the database.
	@Data
	private static class AppUser {
		private Integer id;
		private String username, password;
		private String role;
	}
}