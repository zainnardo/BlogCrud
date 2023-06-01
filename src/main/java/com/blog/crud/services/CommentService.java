package com.blog.crud.services;

import com.blog.crud.payloads.CommentDto;

public interface CommentService {
	public CommentDto createComment(CommentDto commentDto,Integer postId);
	public CommentDto deleteComment(Integer commentId);
}
