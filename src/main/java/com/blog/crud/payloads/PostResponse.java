package com.blog.crud.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
	private List<PostDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private boolean lastPage;
	
}
