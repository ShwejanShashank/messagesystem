package com.example.messagesystem.controller;

import com.example.messagesystem.model.Message;
import com.example.messagesystem.repo.MessageRepository;
import com.example.messagesystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/api/messages")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.sendMessage(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/api/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/api/messages/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable String id) {
        Message message = messageService.getMessageById(id);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/messages/receiver/{receiver}")
    public ResponseEntity<List<Message>> getMessagesByReceiver(@PathVariable String receiver) {
        List<Message> messages = messageService.getMessagesForReceiver(receiver);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PutMapping("/api/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable String id, @RequestBody Message updatedMessage) {
        Message updated = messageService.updateMessage(id, updatedMessage);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        boolean deleted = messageService.deleteMessage(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
