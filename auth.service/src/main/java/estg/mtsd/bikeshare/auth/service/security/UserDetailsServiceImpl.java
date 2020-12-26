package estg.mtsd.bikeshare.auth.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.auth.service.service.AccountServiceProxy;
import lombok.Data;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountServiceProxy accountServiceProxy;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = accountServiceProxy.getUserByUsername(username);
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

		private String username;

		private String password;

		private String role;
	}
}