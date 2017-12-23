package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.beans.Message;

public interface MessageBoardService {

	public List<Message> listMessages();

	public void postMessage(Message message);

	public void deleteMessage(Message message);

	public Message findMessageById(Long messageId);
}
