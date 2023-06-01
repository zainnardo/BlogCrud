package com.blog.crud.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	private String content;
	@ManyToOne()
	private Post post;
}
