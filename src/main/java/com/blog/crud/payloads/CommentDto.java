package com.blog.crud.payloads;

import lombok.Data;

@Data
public class CommentDto {
	private Integer commentId;
	private String content;
}
