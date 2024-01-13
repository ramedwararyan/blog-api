package com.project.blog.services;

import java.util.List;

import com.project.blog.entities.Post;
import com.project.blog.payloads.PostDto;
import com.project.blog.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto , Integer postId);
	
    //delete
	void deletePost(Integer postId);
	
	//getAllPosts
	PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy,String sortDir);
	
	//getPostById
	PostDto getPostById(Integer postId);
	
	//getCategory
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//getCategoryById
	List<PostDto> getPostsById(Integer userId);
	
	//search
	List<PostDto> searchPosts(String keyword);
}
