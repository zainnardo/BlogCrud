package com.blog.crud.services;


import com.blog.crud.payloads.UserDto;

import java.util.List;

public interface UserService {
	public UserDto registerUser(UserDto userDto);
	public UserDto createUser(UserDto userDto);
	public UserDto updateUser(UserDto userDto,Integer userId);
	public UserDto getUserById(Integer userId);
	public List<UserDto> getAllUsers();
	public UserDto deleteUser(Integer userId);
	 
}
