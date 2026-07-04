package com.vimaltech.ai_powered_customer_support_platform.service.ai;

import com.vimaltech.ai_powered_customer_support_platform.client.ollama.OllamaRequest;
import com.vimaltech.ai_powered_customer_support_platform.client.ollama.OllamaResponse;
import com.vimaltech.ai_powered_customer_support_platform.config.OllamaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class OllamaService implements AiService {

    private final RestClient ollamaRestClient;
    private final OllamaProperties properties;

    @Override
    public String generateResponse(String userMessage) {

        log.info("Sending prompt to Ollama");

        OllamaRequest request = new OllamaRequest(
                properties.model(),
                userMessage,
                false
        );

        OllamaResponse response = ollamaRestClient
                .post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(OllamaResponse.class);

        if (response == null || response.response() == null) {
            return "Unable to generate response.";
        }

        return response.response().trim();
    }
}