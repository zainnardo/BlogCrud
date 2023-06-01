package com.blog.crud.security;

import com.blog.crud.exceptions.ResourceNotFoundException;
import com.blog.crud.models.User;
import com.blog.crud.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User ", " email : "+username, 0));
		return user;
	}

}
