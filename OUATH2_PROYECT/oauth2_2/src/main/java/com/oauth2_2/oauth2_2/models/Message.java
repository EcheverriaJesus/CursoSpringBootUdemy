package com.oauth2_2.oauth2_2.models;

import lombok.Data;

@Data
public class Message {
    
    private String text;

    public Message() {

    }

    public Message(String text) {
        this.text = text;
    }

}
