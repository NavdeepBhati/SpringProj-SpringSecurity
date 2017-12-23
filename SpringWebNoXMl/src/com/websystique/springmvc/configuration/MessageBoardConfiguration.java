package com.websystique.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.websystique.springmvc.service.MessageBoardService;
import com.websystique.springmvc.service.MessageBoardServiceImpl;

@Configuration
public class MessageBoardConfiguration {
	@Bean
	public MessageBoardService messageBoardService() {
		return new MessageBoardServiceImpl();
	}
}