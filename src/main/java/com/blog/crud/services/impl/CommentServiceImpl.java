package com.blog.crud.services.impl;

import com.blog.crud.exceptions.ResourceNotFoundException;
import com.blog.crud.models.Comment;
import com.blog.crud.models.Post;
import com.blog.crud.payloads.CommentDto;
import com.blog.crud.repositories.CommentRepo;
import com.blog.crud.repositories.PostRepo;
import com.blog.crud.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id ", postId));
		Comment comment=modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment=commentRepo.save(comment);
		return modelMapper.map(savedComment,CommentDto.class);
	}

	@Override
	public CommentDto deleteComment(Integer commentId) {
		Comment comment=commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment ", " Comment id ", commentId));
		commentRepo.delete(comment);
		return modelMapper.map(comment, CommentDto.class);
		
	}

}
