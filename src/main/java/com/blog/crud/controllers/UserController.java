package com.blog.crud.controllers;

import com.blog.crud.payloads.UserDto;
import com.blog.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUserController(@Valid @RequestBody UserDto userDto){
		return new ResponseEntity<UserDto>(userService.createUser(userDto),HttpStatus.CREATED);
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUserController(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
		return new ResponseEntity<UserDto>(userService.updateUser(userDto, userId),HttpStatus.OK);
	}
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getUserByIdController(@PathVariable("userId") Integer userId){
		return new ResponseEntity<UserDto>(userService.getUserById(userId),HttpStatus.OK);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsersController(){
		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(),HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<UserDto> deleteUserController(@PathVariable("userId") Integer userId){
		return new ResponseEntity<UserDto>(userService.deleteUser(userId),HttpStatus.OK);
	}
	
}
