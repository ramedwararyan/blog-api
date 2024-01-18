package com.project.blog.security;


import com.project.blog.payloads.UserDto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}
