package com.hostmdy.hmi.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SimpleEmailRequest {
	
	private String to;
	private String subject;
	private String text;

}
