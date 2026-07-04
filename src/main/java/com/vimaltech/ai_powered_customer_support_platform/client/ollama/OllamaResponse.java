package com.vimaltech.ai_powered_customer_support_platform.client.ollama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OllamaResponse(
        String response
) {
}
