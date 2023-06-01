package com.blog.crud.controllers;

import com.blog.crud.payloads.CommentDto;
import com.blog.crud.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/create/{postId}")
	public ResponseEntity<CommentDto> createCommentController(@RequestBody CommentDto commentDto,@PathVariable Integer postId) {
		return new ResponseEntity<CommentDto>(commentService.createComment(commentDto, postId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<CommentDto> deleteCommentController(@PathVariable Integer commentId) {
		return new ResponseEntity<CommentDto>(commentService.deleteComment(commentId),HttpStatus.OK);
	}
}
