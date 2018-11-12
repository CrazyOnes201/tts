package com.dbsd6th.security;

import com.dbsd6th.dao.UserMapper;
import com.dbsd6th.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.selectByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("找不到该用户");
		}
//		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
//		grantedAuthorities.add(grantedAuthority);
		return new MyUserDetail(user, getAuthorities(user.getUserRole()));
	}

	private Collection<GrantedAuthority> getAuthorities(String role) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

}
