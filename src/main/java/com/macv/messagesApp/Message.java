package com.macv.messagesApp;

public class Message {
    private int idMessage;
    private String message;
    private String messageAuthor;
    private String messageDate;

    Message(){

    }

    public Message(String message, String message_author) {
        this.message = message;
        this.messageAuthor = message_author;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String message_author) {
        this.messageAuthor = message_author;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String message_date) {
        this.messageDate = message_date;
    }
}
