package com.vimaltech.ai_powered_customer_support_platform.client.ollama;

public record OllamaRequest(
        String model,
        String prompt,
        boolean stream
) {
}
