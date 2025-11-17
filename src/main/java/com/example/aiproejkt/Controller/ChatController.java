package com.example.aiproejkt.Controller;

import com.example.aiproejkt.Model.ChatSession;
import com.example.aiproejkt.DTO.ChatRequest;
import com.example.aiproejkt.Service.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChatController {

    private final ChatMessageService chatService;

    public ChatController(ChatMessageService chatService) {
        this.chatService = chatService;
    }

    // Opret ny session
    @PostMapping("/session")
    public ResponseEntity<ChatSession> createSession(@RequestParam String name) {
        ChatSession session = chatService.createSession(name);
        return ResponseEntity.ok(session);
    }

    // Hent specifik session
    @GetMapping("/session/{id}")
    public ResponseEntity<ChatSession> getSession(@PathVariable int id) {
        return chatService.getSession(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Hent alle sessions
    @GetMapping("/sessions")
    public ResponseEntity<List<ChatSession>> getAllSessions() {
        return ResponseEntity.ok(chatService.getAllSessions());
    }

    // Send besked og få AI-svar
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest dto) {
        String reply = chatService.handleMessage(dto);
        return ResponseEntity.ok(reply);
    }
}
