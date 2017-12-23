package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.beans.Message;
import com.websystique.springmvc.service.MessageBoardService;

@Controller
@RequestMapping("/messageList*")
public class MessageListController {
	private MessageBoardService messageBoardService;

	@Autowired
	public MessageListController(MessageBoardService messageBoardService) {
		this.messageBoardService = messageBoardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String generateList(Model model) {
		List<Message> messages = java.util.Collections.emptyList();
		messages = messageBoardService.listMessages();
		Message m = new Message();
		m.setBody("sas");
		m.setId(1L);
		m.setTitle("dsd");
		m.setAuthor("ddsdsd");
		messages.add(m);
		model.addAttribute("messages", messages);
		return "messageList";

	}
}