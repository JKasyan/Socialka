package com.kasyan.Socialka.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kasyan.Socialka.dao.UserDao;
import com.kasyan.Socialka.dto.UserRole;

public class SignInServiceImpl implements UserDetailsService{
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public UserDetails loadUserByUsername(final String email)
			throws UsernameNotFoundException {
		com.kasyan.Socialka.dto.User user = userDao.getByEmail(email);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
	
	private User buildUserForAuthentication(com.kasyan.Socialka.dto.User user, List<GrantedAuthority> authorities){
		return new User(user.getEmail(), user.getPassword(),user.isEnabled(), true, true, true, authorities);
	}
}
