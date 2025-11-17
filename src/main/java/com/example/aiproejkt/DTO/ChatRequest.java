package com.example.aiproejkt.DTO;

public class ChatRequest {
    private int sessionId;
    private String message;

    public int getSessionId() { return sessionId; }
    public void setSessionId(int sessionId) { this.sessionId = sessionId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
