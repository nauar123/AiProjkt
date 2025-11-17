package com.example.aiproejkt.Service;

import com.example.aiproejkt.Model.ChatSession;
import com.example.aiproejkt.Model.Message;
import com.example.aiproejkt.DTO.ChatRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatMessageService {

    private Map<Integer, ChatSession> sessions = new HashMap<>();
    private int nextId = 1; // simpel ID-tæller

    // Opret ny session
    public ChatSession createSession(String name) {
        int id = nextId++; // brug simpel tæller
        ChatSession session = new ChatSession(id, name);
        sessions.put(id, session);
        return session;
    }

    // Hent session
    public ChatSession getSession(int id) {
        return sessions.get(id); // returnerer null hvis ikke findes
    }

    // Hent alle sessions
    public List<ChatSession> getAllSessions() {
        return new ArrayList<>(sessions.values());
    }

    // Håndter besked fra bruger
    public String handleMessage(ChatRequest dto) {
        ChatSession session = sessions.get(dto.getSessionId());
        if (session == null) return "Session findes ikke";

        // Tilføj brugerbesked
        session.getMessages().add(new Message("user", dto.getMessage()));

        // Dummy AI-svar
        String aiReply = "AI-svar til: " + dto.getMessage();

        // Tilføj AI-svar
        session.getMessages().add(new Message("assistant", aiReply));

        return aiReply;
    }
}
