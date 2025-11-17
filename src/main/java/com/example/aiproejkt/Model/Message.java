package com.example.aiproejkt.Model;


public class Message {
    private String role;
    private String content;

    public Message(String role, String content) {
        this.role = role; // personen der skriver besekde
        this.content = content; // selve beskeden
    }


    public String getRole()
    {
        return role;
    }
    public String getContent()
    {
        return content;
    }
}
