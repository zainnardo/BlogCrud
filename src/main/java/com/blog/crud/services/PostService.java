package com.blog.crud.services;

import com.blog.crud.models.Post;
import com.blog.crud.payloads.PostDto;
import com.blog.crud.payloads.PostResponse;

import java.util.List;

public interface PostService {
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	public PostDto updatePost(PostDto postDto,Integer postId);
	public Post deletePost(Integer postId);
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	public PostDto getPostById(Integer postId);
	public List<PostDto> getPostByCategory(Integer categoryId);
	public List<PostDto> getPostByUser(Integer userId);
	public List<PostDto> searchPosts(String keyword);
}
