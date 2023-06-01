package com.blog.crud.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Role {
	@Id
	private Integer id;
	private String name;
}
