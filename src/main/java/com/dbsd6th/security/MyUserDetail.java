package com.dbsd6th.security;

import com.dbsd6th.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserDetail implements UserDetails {
	private User myUser;
	private Collection<? extends GrantedAuthority> authorities;

	public MyUserDetail(User user, Collection<? extends GrantedAuthority> authorities) {
		this.myUser = user;
		this.authorities = authorities;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}


	public String getPassword() {
		return myUser.getUserPassword();
	}


	public String getUsername() {
		return myUser.getUserName();
	}


	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
