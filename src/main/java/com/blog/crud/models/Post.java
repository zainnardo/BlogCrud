package com.blog.crud.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String title;
	@Column(length = 1000)
	private String content;
	private String imageName;
	private Date addedDate;
	
	@ManyToOne()
	private Category category;
	@ManyToOne()
	private User user;
	
	@OneToMany(mappedBy ="post",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<Comment> comments=new HashSet<>();
}
