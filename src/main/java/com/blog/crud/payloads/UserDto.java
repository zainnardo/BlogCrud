package com.blog.crud.payloads;

import com.blog.crud.models.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
	private Integer id;
	@NotEmpty
	@Size(min = 4,message = "username must be min of 4 characters !!")
	private String name;
	@NotEmpty 
	@Email(message = "email address is not valid !!")
	private String email;
	@NotEmpty
	private String about;
	@NotEmpty
	@Size(min=3,max=10,message = "Password must be min of 3 and max of 4 characters !!")
	private String password;
	
	private Set<Role> roles=new HashSet<>();
}
