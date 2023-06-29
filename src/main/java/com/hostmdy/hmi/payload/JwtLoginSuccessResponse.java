package com.hostmdy.hmi.payload;

import java.util.List;

import com.hostmdy.hmi.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtLoginSuccessResponse {

	private boolean success;
	private String token;
	private User user;
	private List<String> roleList;
}
