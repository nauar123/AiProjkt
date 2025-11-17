package com.example.aiproejkt.Model;

import java.util.ArrayList;
import java.util.List;

public class ChatSession {
    private int id;
    private String name;
    private List<Message> messages;

    public ChatSession(int id, String Name) {
        this.id = id;
        this.name = name;
        this.messages = new ArrayList<>();
    }

    // Getters og setters
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public List<Message> getMessages()
    {
        return messages;
    }
}
