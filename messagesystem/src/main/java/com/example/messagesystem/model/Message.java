package com.example.messagesystem.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@Document(collection="messages")
public class Message {

    @Id
    private String id;
    private String sender;
    private String receiver;
    private String text;
    private Instant timeStamp;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }



    public Message(String id, String sender, String receiver, String text, Instant timeStamp) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.timeStamp = timeStamp;

    }
    public Message()
    {

    }
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", text='" + text + '\'' +
                ", timeStamp=" + timeStamp +

                '}';
    }


}
