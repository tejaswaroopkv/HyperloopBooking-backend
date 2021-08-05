package com.fightbook.adminManager.io;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("tejaswaroop.kuppa09@gmail.com".equals(username)) {
			return new User("tejaswaroop.kuppa09@gmail.com", "$2a$10$bEpxSVXnQwQVKdJSRMga4OW5.FfskJrSw.FkczYGenfTFBqZZEnfq",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
