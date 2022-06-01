package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Message;
import com.revature.services.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping(path="/message/createmessage")
	public @ResponseBody boolean createMessage(@RequestBody Message message) {
		System.out.println("@MessageController - createMessage: " + message.toString());
		return messageService.createMessage(message);
	}
	
	// get all msgs
	@GetMapping(path="/message/all")
	public @ResponseBody List<Message> allMessages(){
		return messageService.getAllMessages();
	}
	
	@GetMapping(path="/message/byactivity")
	public @ResponseBody List<Message> messagesByActivity(@RequestBody int activity_id) {
		return messageService.getMessageByActivity(activity_id);
	}
	
	@GetMapping(path="/message/byuserid")
	public @ResponseBody List<Message> messagesByUser(@RequestBody int user_id) {
		return messageService.getMessageByAuthor(user_id);
	}
	
	@PutMapping(path = "/message/update")
	public @ResponseBody boolean updateMessage(@RequestBody Message message) {
		return messageService.updateMessage(message);
	}
	
	@DeleteMapping(path = "/message/delete")
	public @ResponseBody boolean deleteMessage(@RequestBody Message message) {
		return messageService.deleteMessage(message);
	}
}
