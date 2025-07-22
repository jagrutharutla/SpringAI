package com.jagruth.aiproject;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAiController {
    private OpenAiChatModel chatModel;

    public OpenAiController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getOpenAiResponse(@RequestBody String input) {
        String response = chatModel.call(input);
        return ResponseEntity.ok(response);
    }
}
