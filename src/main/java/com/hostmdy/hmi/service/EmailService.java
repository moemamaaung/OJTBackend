package com.hostmdy.hmi.service;

import com.hostmdy.hmi.payload.SimpleEmailRequest;

public interface EmailService {
	void sendEmail(SimpleEmailRequest email);
}
