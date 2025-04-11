package com.example.messagesystem.service;

import com.example.messagesystem.model.Message;
import com.example.messagesystem.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;


    public Message sendMessage(Message message) {
        message.setTimeStamp(Instant.now());
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public Message getMessageById(String id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null); // Returns null if not found
    }
    public List<Message> getMessagesForReceiver(String receiver) {
        return messageRepository.findByReceiver(receiver);
    }

    public Message updateMessage(String id, Message updatedMessage) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            Message message = existingMessage.get();
            message.setText(updatedMessage.getText());
            return messageRepository.save(message);
        } else {
            return null;
        }
    }
    public boolean deleteMessage(String id) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            messageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
